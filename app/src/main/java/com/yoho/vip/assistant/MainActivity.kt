package com.yoho.vip.assistant

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // التحقق من إذن الظهور فوق التطبيقات
        if (!Settings.canDrawOverlays(this)) {
            startActivity(
                Intent(
                    Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:$packageName")
                )
            )
            Toast.makeText(this, "فعّل إذن الظهور فوق التطبيقات", Toast.LENGTH_LONG).show()
        }

        // زر اختيار الصورة
        findViewById<Button>(R.id.btn_select).setOnClickListener {
            Toast.makeText(this, "اختيار الصورة...", Toast.LENGTH_SHORT).show()
            // سيتم إضافة كود اختيار الصورة لاحقاً
        }

        // زر الحفظ والرفع
        findViewById<Button>(R.id.btn_save).setOnClickListener {
            Toast.makeText(this, "حفظ الصورة...", Toast.LENGTH_SHORT).show()
            // سيتم إضافة كود الحفظ لاحقاً
        }

        // بدء الخدمة العائمة
        startService(Intent(this, FloatingService::class.java))
    }
}