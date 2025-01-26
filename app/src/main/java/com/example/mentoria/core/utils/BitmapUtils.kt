package com.example.mentoria.core.utils

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.Typeface
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

fun createImageFromText(text: String): Bitmap {
    val width = 800
    val height = 400
    val padding = 50f
    val cornerRadius = 60f

    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)

    val backgroundPaint = Paint().apply {
        color = Color.parseColor("#F5F5F5")
        isAntiAlias = true
    }
    val rect = RectF(0f, 0f, width.toFloat(), height.toFloat())
    canvas.drawRoundRect(rect, cornerRadius, cornerRadius, backgroundPaint)

    val textPaint = TextPaint().apply {
        color = Color.BLACK
        textSize = 50f
        isAntiAlias = true
        textAlign = Paint.Align.LEFT
        typeface = Typeface.DEFAULT_BOLD
    }

    val watermarkPaint = Paint().apply {
        color = Color.GRAY
        textSize = 40f
        isAntiAlias = true
        textAlign = Paint.Align.RIGHT
        typeface = Typeface.DEFAULT_BOLD
    }

    val maxTextWidth = width - (2 * padding)
    val textLayout = StaticLayout.Builder
        .obtain(text, 0, text.length, textPaint, maxTextWidth.toInt())
        .setAlignment(Layout.Alignment.ALIGN_NORMAL)
        .setLineSpacing(1.5f, 1.2f)
        .setIncludePad(true)
        .build()

    canvas.save()
    canvas.translate(padding, padding)
    textLayout.draw(canvas)
    canvas.restore()

    canvas.drawText(
        "MentorIA",
        (width - padding),
        (height - padding / 2),
        watermarkPaint
    )

    return bitmap
}

fun shareImage(context: Context, bitmap: Bitmap) {
    val tempFile = File(context.cacheDir, "shared_image.png")
    var outputStream: OutputStream? = null

    try {
        outputStream = FileOutputStream(tempFile)
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        outputStream.flush()

        val contentUri = FileProvider.getUriForFile(
            context,
            context.packageName + ".fileprovider", // Certifique-se de ter configurado o FileProvider no AndroidManifest.xml
            tempFile
        )

        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, contentUri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }

        context.startActivity(Intent.createChooser(shareIntent, "Compartilhar imagem"))
    } catch (e: IOException) {
        e.printStackTrace()
    } finally {
        outputStream?.close()
    }
}