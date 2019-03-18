package com.billy.petsadoption.view

import android.app.AlertDialog
import android.content.Context
import android.util.DisplayMetrics
import android.widget.ProgressBar
import org.jetbrains.anko.windowManager

class ProgressView(var context: Context) {
    private var alertDialog: AlertDialog.Builder
    private lateinit var alert: AlertDialog
    private var metrics: DisplayMetrics

    init {
        metrics = DisplayMetrics()
        context.windowManager.defaultDisplay.getMetrics(metrics)

        alertDialog = AlertDialog.Builder(context)
        alertDialog.setView(ProgressBar(context))
        alertDialog.setCancelable(false)
    }

    fun setMessage(msg: String) {
        alertDialog.setMessage(msg)
    }

    fun show() {
        alert = alertDialog.show()
        alert.window.setLayout(metrics.widthPixels / 3 * 2, metrics.heightPixels / 4)
    }

    fun close() {
        alert.dismiss()
    }
}