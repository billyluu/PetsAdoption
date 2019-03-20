package com.billy.petsadoption.view

import android.content.Context
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.billy.petsadoption.R
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.windowManager
import java.util.*
import kotlin.concurrent.timerTask

class Counter: FrameLayout {
    private val TAG = javaClass.simpleName

    var startValue = 0
        set(value) {
            field = value
        }
    var endValue = 0
        set(value){
            field = value
        }
    var incrementValue = 0



    private var metrics: DisplayMetrics? = null
    private var mDesiredSize: Int = 0

    private var counter_text: TextView? = null

    constructor(context: Context): this(context, null) {

        metrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(metrics)

    }
    constructor(context: Context, attrs: AttributeSet?): this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.Counter, 0, 0)

        startValue = typedArray.getResourceId(R.styleable.Counter_startValue, 0)
        endValue = typedArray.getResourceId(R.styleable.Counter_endValue, 0)
        incrementValue = typedArray.getResourceId(R.styleable.Counter_incrementValue, 0)

        var view = LayoutInflater.from(context).inflate(R.layout.counter_view, this, true)
        counter_text = view.findViewById(R.id.count_text)


    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    fun startCount() {
        var currentValue = 0
        var t = Timer("updateUI", false)
        t.schedule(timerTask {
            context.runOnUiThread {
                if (currentValue < endValue) {
                    counter_text!!.text = currentValue.toString()
                    currentValue += 3
                } else {
                    counter_text!!.text = endValue.toString()
                    t.cancel()
                    hide()
                }

            }
        }, 0L, 1)
    }

    private fun hide() {
        Timer("hide", false)
            .schedule(timerTask {
                context.runOnUiThread {
                    this@Counter.visibility = View.INVISIBLE
                }
            }, 2000)
    }

//    class CountRun(var view: Counter, start: Float, end: Float): Runnable {
//
//        private var currentValue = 0
//
//        override fun run() {
//            view.post
//        }
//    }
}