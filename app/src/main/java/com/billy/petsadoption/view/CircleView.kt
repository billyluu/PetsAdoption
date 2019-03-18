package com.billy.petsadoption.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.billy.petsadoption.R

class CircleView: View {

    private var count: Int? = null

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        var typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CircleView, 0, 0)
        try {
            count = typedArray.getInt(R.styleable.CircleView_count, 0)
        } catch (e: Exception) {
            typedArray.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val verticalCenter = height / 2f
        val horizontalCenter = width / 2f
        val circleRadius = 200f

        var paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.BLACK
        paint.alpha = 100
        canvas!!.drawCircle(horizontalCenter, verticalCenter - 250, circleRadius, paint)

        var textPaint = Paint()
        textPaint.textSize = 25f
        textPaint.color = Color.WHITE

        //canvas.drawText("ABC", horizontalCenter, verticalCenter - 250, textPaint)
//        for (i in 0..count!!) {
//            canvas.
//            canvas.drawText("${i}", horizontalCenter, verticalCenter - 250, textPaint)
//            canvas.save()
//            canvas.restore()
//        }



    }




}

