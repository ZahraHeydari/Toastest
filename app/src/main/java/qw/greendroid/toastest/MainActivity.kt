package qw.greendroid.toastest

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import qw.greendroid.library.Toastest
import qw.greendroid.library.Toastest.Companion.makeAnim
import android.view.animation.AccelerateDecelerateInterpolator
import qw.greendroid.library.Toastest.Companion.makeGravity


class MainActivity : AppCompatActivity() {

    private val TEXT_SIZE: Int = 20 // in sp
    private val TEXT_COLOR: Int = Color.parseColor("#FF0000")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast_button.setOnClickListener {
            Toastest.makeToast(this, getString(R.string.a_normal_toast), Toast.LENGTH_SHORT).show()
        }

        toast_custom_with_icon_button.setOnClickListener {
            Toastest.makeToast(this,
                    getString(R.string.a_toast_with_icon),
                    ContextCompat.getDrawable(this, R.drawable.ic_toast),
                    Toast.LENGTH_SHORT)
                    .show()
        }

        toast_custom_with_new_background_button.setOnClickListener {
            Toastest.makeToast(this,
                    ContextCompat.getDrawable(this, R.drawable.toastest_red_background),
                    getString(R.string.a_toast_with_new_background),
                    Toast.LENGTH_SHORT)
                    .show()

        }

        toast_custom_with_new_font_type_button.setOnClickListener {
            Toastest.makeToast(this,
                    getString(R.string.a_toast_with_new_font_type),
                    Typeface.createFromAsset(applicationContext.assets, "fonts/AtlantaBook.ttf"),
                    Toast.LENGTH_SHORT)
                    .show()
        }

        toast_custom_with_new_text_size_button.setOnClickListener {
            Toastest.makeToast(this,
                    getString(R.string.a_toast_with_new_text_size),
                    TEXT_SIZE,
                    Toast.LENGTH_SHORT)
                    .show()

        }

        toast_custom_fully_button.setOnClickListener {

            Toastest.custom(this,
                    getString(R.string.a_toast_with_new_text_size),
                    ContextCompat.getDrawable(this, R.drawable.ic_toast),
                    ContextCompat.getDrawable(this, R.drawable.toastest_red_background),
                    Typeface.createFromAsset(applicationContext.assets, "fonts/AtlantaBook.ttf"),
                    TEXT_COLOR,
                    TEXT_SIZE,
                    Toast.LENGTH_SHORT)
                    .show()
        }


        toast_custom_with_new_gravity_button.setOnClickListener {
            Toastest.makeToast(this,
                    getString(R.string.a_toast_with_new_font_type),
                    Toast.LENGTH_SHORT)
                    .apply {
                        makeGravity(this, Gravity.CENTER)// when needs to change gravity
                    }
                    .show()
        }


        toast_custom_with_anim_button.setOnClickListener {
            Toastest.makeToast(this,
                    getString(R.string.a_toast_with_new_font_type),
                    Toast.LENGTH_SHORT)
                    .apply {
                        makeAnim(this,
                                "translationX",
                                2000,
                                AccelerateDecelerateInterpolator(),
                                -400f,
                                0f)
                    }
                    .show()
        }

        toast_custom_with_anim_and_new_gravity_button.setOnClickListener {
            Toastest.makeToast(this,
                    getString(R.string.a_toast_with_new_font_type),
                    Toast.LENGTH_SHORT)
                    .apply {
                        makeAnim(this,
                                "translationY",
                                2000,
                                -400f,
                                0f)
                        makeGravity(this, Gravity.TOP)// when needs to change gravity
                    }
                    .show()
        }
    }
}

