package qw.greendroid.toastest

import android.widget.Button
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat


@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    var button: Button? = null

    @Before
    fun setUp() {
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        button = activity.findViewById<Button>(R.id.toast_button)
    }

    @Test
    fun showToast() {
        button?.performClick()
    }

    fun showError(){
        button?.performClick()
       // assertThat("Show error for Button field ", button?.error, `is`(CoreMatchers.notNullValue()))
    }


}