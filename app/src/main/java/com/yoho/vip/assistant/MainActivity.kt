package com.yoho.vip.assistant

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var frameEditor: FrameEditor
    private var selectedImageUri: Uri? = null
    private var currentBitmap: Bitmap? = null
    private lateinit var imgPreview: ImageView
    private lateinit var edtUserName: EditText
    private lateinit var progressBar: ProgressBar

    companion object {
        private const val REQUEST_IMAGE_PICK = 1001
        private const val REQUEST_CAMERA = 1002
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frameEditor = FrameEditor()
        initViews()
        checkPermissions()
        setupListeners()
        startService(Intent(this, FloatingService::class.java))
    }

    private fun initViews() {
        imgPreview = findViewById(R.id.img_preview)
        edtUserName = findViewById(R.id.edt_username)
        progressBar = findViewById(R.id.progress_bar)
        progressBar.visibility = ProgressBar.GONE
    }

    private fun checkPermissions() {
        if (!Settings.canDrawOverlays(this)) {
            startActivity(
                Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
            )
            Toast.makeText(this, "فعّل إذن الظهور فوق التطبيقات", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupListeners() {
        // زر اختيار الصورة
        findViewById<Button>(R.id.btn_select).setOnClickListener {
            showImageOptions()
        }

        // زر الحفظ والرفع
        findViewById<Button>(R.id.btn_save).setOnClickListener {
            saveAndUpload()
        }

        // زر الإطار الذهبي
        findViewById<Button>(R.id.btn_gold_frame).setOnClickListener {
            applyGoldFrame()
        }

        // زر الإطار الفضي
        findViewById<Button>(R.id.btn_silver_frame).setOnClickListener {
            applySilverFrame()
        }
    }

    private fun showImageOptions() {
        val options = arrayOf("اختر من المعرض", "التقط صورة")
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("اختر طريقة الحصول على صورة")
        builder.setItems(options) { _, which ->
            when (which) {
                0 -> openGallery()
                1 -> openCamera()
            }
        }
        builder.show()
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE_PICK)
    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CAMERA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode != Activity.RESULT_OK) return

        when (requestCode) {
            REQUEST_IMAGE_PICK -> {
                selectedImageUri = data?.data
                selectedImageUri?.let { loadImageFromUri(it) }
                Toast.makeText(this, "تم اختيار الصورة", Toast.LENGTH_SHORT).show()
            }
            REQUEST_CAMERA -> {
                val bitmap = data?.getParcelableExtra<Bitmap>("data")
                bitmap?.let {
                    currentBitmap = it
                    imgPreview.setImageBitmap(it)
                    Toast.makeText(this, "تم التقاط الصورة", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun loadImageFromUri(uri: Uri) {
        try {
            val inputStream = contentResolver.openInputStream(uri)
            currentBitmap = BitmapFactory.decodeStream(inputStream)
            imgPreview.setImageBitmap(currentBitmap)
        } catch (e: Exception) {
            Toast.makeText(this, "خطأ في تحميل الصورة: ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun applyGoldFrame() {
        if (currentBitmap == null) {
            Toast.makeText(this, "اختر صورة أولاً", Toast.LENGTH_SHORT).show()
            return
        }

        val userName = edtUserName.text.toString().ifEmpty { "VIP User" }
        progressBar.visibility = ProgressBar.VISIBLE

        try {
            val framedBitmap = frameEditor.addRoyalFrame(currentBitmap!!, userName)
            currentBitmap = framedBitmap
            imgPreview.setImageBitmap(framedBitmap)
            Toast.makeText(this, "تم تطبيق الإطار الذهبي ✨", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "خطأ: ${e.message}", Toast.LENGTH_SHORT).show()
        } finally {
            progressBar.visibility = ProgressBar.GONE
        }
    }

    private fun applySilverFrame() {
        if (currentBitmap == null) {
            Toast.makeText(this, "اختر صورة أولاً", Toast.LENGTH_SHORT).show()
            return
        }

        val userName = edtUserName.text.toString().ifEmpty { "VIP User" }
        progressBar.visibility = ProgressBar.VISIBLE

        try {
            val framedBitmap = frameEditor.addSilverFrame(currentBitmap!!, userName)
            currentBitmap = framedBitmap
            imgPreview.setImageBitmap(framedBitmap)
            Toast.makeText(this, "تم تطبيق الإطار الفضي ✨", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(this, "خطأ: ${e.message}", Toast.LENGTH_SHORT).show()
        } finally {
            progressBar.visibility = ProgressBar.GONE
        }
    }

    private fun saveAndUpload() {
        if (currentBitmap == null) {
            Toast.makeText(this, "لا توجد صورة لحفظها", Toast.LENGTH_SHORT).show()
            return
        }

        progressBar.visibility = ProgressBar.VISIBLE

        try {
            // حفظ الصورة
            val fileName = "VIP_${SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())}.jpg"
            val file = saveImageToStorage(fileName, currentBitmap!!)

            if (file != null) {
                Toast.makeText(this, "✅ تم حفظ الصورة: ${file.absolutePath}", Toast.LENGTH_LONG).show()

                // يمكن إضافة كود الرفع إلى يوهو هنا لاحقاً
                openImageInGallery(file)
            } else {
                Toast.makeText(this, "فشل حفظ الصورة", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            Toast.makeText(this, "خطأ: ${e.message}", Toast.LENGTH_SHORT).show()
        } finally {
            progressBar.visibility = ProgressBar.GONE
        }
    }

    private fun saveImageToStorage(fileName: String, bitmap: Bitmap): File? {
        return try {
            val storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
            val imageFile = File(storageDir, fileName)

            FileOutputStream(imageFile).use { fos ->
                bitmap.compress(Bitmap.CompressFormat.JPEG, 95, fos)
            }

            imageFile
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private fun openImageInGallery(file: File) {
        try {
            val uri = FileProvider.getUriForFile(
                this,
                "${packageName}.fileprovider",
                file
            )
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, "image/*")
                flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
            }
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "لا يمكن فتح الصورة", Toast.LENGTH_SHORT).show()
        }
    }
}
