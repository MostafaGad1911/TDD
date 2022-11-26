package mostafagad.projects.tdd

import mostafagad.projects.tdd.utils.LoginValidator
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class LoginValidatorTest{

    @Test
    fun loginInputValid(){
        val checkPhoneValid = LoginValidator.validatePhone(phone = "01553145558")
        val checkPasswordValid = LoginValidator.validatePassword(password = "Mdadas!5@")
        assertTrue(checkPhoneValid && checkPasswordValid)
    }

    @Test
    fun loginInputInValid(){
        val checkPhoneValid = LoginValidator.validatePhone(phone = "015535558")
        val checkPasswordValid = LoginValidator.validatePassword(password = "Mdadas!@")
        assertFalse(checkPhoneValid && checkPasswordValid)
    }
}