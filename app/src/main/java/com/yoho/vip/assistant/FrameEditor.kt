package com.yoho.vip.assistant

import android.graphics.*

class FrameEditor {
    fun addRoyalFrame(original: Bitmap, userName: String): Bitmap {
        val result = Bitmap.createBitmap(original.width, original.height, original.config)
        val canvas = Canvas(result)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        // رسم الصورة الأصلية
        canvas.drawBitmap(original, 0f, 0f, paint)

        // رسم الإطار الذهبي
        paint.style = Paint.Style.STROKE
        paint.color = Color.rgb(255, 215, 0)
        paint.strokeWidth = 40f
        canvas.drawRect(0f, 0f, original.width.toFloat(), original.height.toFloat(), paint)

        // إضافة لمعان علوي
        paint.style = Paint.Style.FILL
        paint.color = Color.argb(60, 255, 255, 255)
        canvas.drawRect(0f, 0f, original.width.toFloat(), 100f, paint)

        // كتابة اسم المستخدم
        paint.color = Color.WHITE
        paint.textSize = 80f
        paint.typeface = Typeface.DEFAULT_BOLD
        paint.setShadowLayer(10f, 0f, 0f, Color.BLACK)
        canvas.drawText(userName, 50f, (original.height - 50).toFloat(), paint)

        return result
    }

    fun addSilverFrame(original: Bitmap, userName: String): Bitmap {
        val result = Bitmap.createBitmap(original.width, original.height, original.config)
        val canvas = Canvas(result)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        canvas.drawBitmap(original, 0f, 0f, paint)

        // إطار فضي
        paint.style = Paint.Style.STROKE
        paint.color = Color.rgb(192, 192, 192)
        paint.strokeWidth = 35f
        canvas.drawRect(0f, 0f, original.width.toFloat(), original.height.toFloat(), paint)

        // اسم المستخدم
        paint.color = Color.WHITE
        paint.textSize = 80f
        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText(userName, 50f, (original.height - 50).toFloat(), paint)

        return result
    }
}