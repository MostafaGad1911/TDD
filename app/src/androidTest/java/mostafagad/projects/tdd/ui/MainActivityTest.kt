package mostafagad.projects.tdd.ui

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test
import mostafagad.projects.tdd.R
import mostafagad.projects.tdd.utils.LoginValidator
import org.junit.Assert
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {

    @get: Rule
    val mainActivityScenario: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun testLoginUser(){
        onView(withId(R.id.mobileNumberEdt)).perform(ViewActions.typeText("0155317310"))
        onView(withId(R.id.passwordNumberEdt)).perform(ViewActions.typeText("Mos55"))
        val checkPhoneValid = LoginValidator.validatePhone(phone =  onView(withId(R.id.mobileNumberEdt)).toString().trim())
        val checkPasswordValid = LoginValidator.validatePassword(password = onView(withId(R.id.passwordNumberEdt)).toString().trim())
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.loginBtn)).perform(click())
        assertTrue(checkPhoneValid && checkPasswordValid)
    }
}