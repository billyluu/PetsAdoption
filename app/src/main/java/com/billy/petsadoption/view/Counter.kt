package com.billy.petsadoption.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.TextView
import com.billy.petsadoption.R

class Counter: FrameLayout {

    private var startValue = 0
    private var endValue = 0
    private var incrementValue = 0

    private var mDesiredSize: Int = 0

    private var counter_text: TextView? = null

    constructor(context: Context): this(context, null) {
        var view = LayoutInflater.from(context).inflate(R.layout.counter_view, this, true)
        counter_text = view.findViewById(R.id.count_text)
    }
    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.Counter, 0, 0)

        startValue = typedArray.getResourceId(R.styleable.Counter_startValue, 0)
        endValue = typedArray.getResourceId(R.styleable.Counter_endValue, 0)
        incrementValue = typedArray.getResourceId(R.styleable.Counter_incrementValue, 0)


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val w = resolveSizeAndState(mDesiredSize, widthMeasureSpec, 0)
        val h = resolveSizeAndState(mDesiredSize, heightMeasureSpec, 0)

        setMeasuredDimension(w, h)
    }
}