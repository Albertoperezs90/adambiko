package com.aperezs.adambiko.utils.text

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class SuffixEditText @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatEditText(context, attrs, defStyleAttr) {

    private val textPaint = TextPaint()
    private var errorMarginPaddingRight = 12f

    override fun onFinishInflate() {
        super.onFinishInflate()
        textPaint.color = currentTextColor
        textPaint.textSize = textSize
        textPaint.textAlign = Paint.Align.LEFT
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val suffixPosition = textPaint.measureText(text.toString()) + errorMarginPaddingRight
        val prefix = tag as String
        canvas?.drawText(
            prefix, suffixPosition, getLineBounds(0, null).toFloat(), textPaint
        )
    }
}