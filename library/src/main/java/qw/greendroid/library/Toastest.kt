package qw.greendroid.library


import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorInt
import android.support.v4.content.ContextCompat.getDrawable
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.view.ViewGroup
import android.animation.*



/**
 * This file is part of Toastest.
 * Defined many functions to customize Toasts.
 *
 *
 * Created by @ZARA on 2018/05/09.
 */
class Toastest {


    companion object {

        @ColorInt
        private var DEFAULT_TEXT_COLOR = Color.parseColor("#FFFFFF")
        private var DEFAULT_TEXT_SIZE = 16
        private val DEFAULT_TEXT_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL)

        fun makeToast(context: Context, message: String, duration: Int): Toast {
            return custom(context, message, null, null, DEFAULT_TEXT_TYPEFACE, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_SIZE, duration)
        }

        fun makeToast(context: Context, message: String, icon: Drawable, duration: Int): Toast {
            return custom(context, message, icon, null, DEFAULT_TEXT_TYPEFACE, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_SIZE, duration)
        }

        fun makeToast(context: Context, message: String, icon: Drawable, background: Drawable, duration: Int): Toast {
            return custom(context, message, icon, background, DEFAULT_TEXT_TYPEFACE, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_SIZE, duration)
        }

        fun makeToast(context: Context, background: Drawable, message: String, duration: Int): Toast {
            return custom(context, message, null, background, DEFAULT_TEXT_TYPEFACE, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_SIZE, duration)
        }

        fun makeToast(context: Context, message: String, textSize: Int, duration: Int): Toast {
            return custom(context, message, null, null, Typeface.DEFAULT_BOLD, DEFAULT_TEXT_COLOR, textSize, duration)
        }

        fun makeToast(context: Context, message: String, fontType: Typeface, duration: Int): Toast {
            return custom(context, message, null, null, fontType, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_SIZE, duration)
        }

        fun makeToast(context: Context, message: String, background: Drawable, fontType: Typeface, duration: Int): Toast {
            return custom(context, message, null, background, fontType, DEFAULT_TEXT_COLOR, DEFAULT_TEXT_SIZE, duration)
        }

        fun makeToast(context: Context, message: String, textSize: Int, fontType: Typeface, duration: Int): Toast {
            return custom(context, message, null, null, fontType, DEFAULT_TEXT_COLOR, textSize, duration)
        }

        fun makeToast(context: Context, message: String, background: Drawable, textSize: Int, fontType: Typeface, duration: Int): Toast {
            return custom(context, message, null, background, fontType, DEFAULT_TEXT_COLOR, textSize, duration)
        }

        fun makeGravity(toast: Toast, gravity:Int){
            toast.setGravity(gravity,0,0)
        }

        fun makeAnim(toast: Toast,
                     propertyName: String,
                     animDuration: Long,
                     animInterpolator: TimeInterpolator,
                     from: Float,
                     to: Float) {
            val anim = ObjectAnimator.ofFloat(toast.view, propertyName, from, to)
            anim.duration = animDuration // Duration in milliseconds
            anim.interpolator = animInterpolator // E.g. Linear, Accelerate, Decelerate
            anim.start() // Begin the animation
        }

        fun makeAnim(toast: Toast,
                     propertyName: String,
                     animDuration: Long,
                     from: Float,
                     to: Float) {
            val anim = ObjectAnimator.ofFloat(toast.view, propertyName, from, to)
            anim.duration = animDuration
            anim.start()
        }


        fun custom(context: Context, message: String, icon: Drawable?,
                   background: Drawable?,
                   fontType: Typeface,
                   textColor: Int,
                   textSize: Int,
                   duration: Int): Toast {
            val currentToast = Toast.makeText(context, "", duration)
            val toastLayout = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                    .inflate(R.layout.toast_layout, null)

            val toastIcon = toastLayout.findViewById<ImageView>(R.id.toast_icon_image_view)
            val toastTextView = toastLayout.findViewById<TextView>(R.id.toast_text_view)

            //toast background
            toastLayout.background = if (background != null) background else getDrawable(context, R.drawable.toastest_background)

            //icon
            if (icon != null) toastIcon.setBackground(icon) else toastIcon.visibility = View.GONE

            toastTextView.text = message
            toastTextView.setTextColor(textColor)
            toastTextView.typeface = fontType
            toastTextView.setTextSize(textSize.toFloat())

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(toastLayout as ViewGroup)
            }
            currentToast.view = toastLayout
            return currentToast
        }

    }

}