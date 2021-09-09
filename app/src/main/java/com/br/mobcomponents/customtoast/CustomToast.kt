package com.br.mobcomponents.customtoast

import android.app.Activity
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.br.mobcomponents.R

object CustomToast {

    private fun showToast(
        activity: Activity,
        backgroundToast: Drawable?,
        icon: Drawable?,
        message: String,
        duration: Int = Toast.LENGTH_SHORT
    ) {
        val toastLayout: View = activity.layoutInflater.inflate(R.layout.custom_toast, null)
        val toast = Toast(activity)
        toast.view = toastLayout
        toast.view.background = backgroundToast
        toastLayout.findViewById<TextView>(R.id.tvMessageToast).text = message
        val ivIconToast = toastLayout.findViewById<ImageView>(R.id.ivIconToast)
        if (icon == null) {
            ivIconToast.visibility = View.GONE
        } else {
            ivIconToast.visibility = View.VISIBLE
            ivIconToast.setImageDrawable(icon)
        }
        toast.duration = duration
        toast.show()
    }

    fun success(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_success),
            ContextCompat.getDrawable(activity, R.drawable.ic_success),
            message
        )
    }

    fun warning(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_warning),
            ContextCompat.getDrawable(activity, R.drawable.ic_warning),
            message
        )
    }

    fun error(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_error),
            ContextCompat.getDrawable(activity, R.drawable.ic_error),
            message
        )
    }

    fun default(activity: Activity, message: String) {
        showToast(
            activity,
            ContextCompat.getDrawable(activity, R.drawable.toast_bg_default),
            null,
            message
        )
    }
}