package mostafagad.projects.tdd.ui

import android.widget.EditText
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.google.android.material.textfield.TextInputLayout
import mostafagad.projects.tdd.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get: Rule
    val mainActivityScenario: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    private val STRING_EMAIL_OR_PHONE = "0155317310"
    private val STRING_PASSWORD = "Mostafa15#"


    @Test
    fun testLoginUser(){
        launchActivity<MainActivity>().use {
            onView(withId(R.id.mobileNumberEdt)).perform(replaceText(STRING_EMAIL_OR_PHONE) , ViewActions.closeSoftKeyboard())
            onView(withId(R.id.passwordNumberEdt)).perform(replaceText(STRING_PASSWORD) , ViewActions.closeSoftKeyboard())
            Thread.sleep(500)

            var email: TextInputLayout? = null
            var password:TextInputLayout? = null
            mainActivityScenario.scenario.onActivity {
                email = it.findViewById(R.id.mobileNumber)
                password = it.findViewById(R.id.passwordNumber)
            }
            onView(withId(R.id.loginBtn)).perform(click())
            assert(email?.error.isNullOrEmpty() && password?.error.isNullOrEmpty())
        }

    }
}