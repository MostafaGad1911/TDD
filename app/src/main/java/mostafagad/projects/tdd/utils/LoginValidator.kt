package mostafagad.projects.tdd.utils

import java.util.regex.Pattern

object LoginValidator {
    fun validatePassword(password:String):Boolean{
        val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{8,}$"
        val passWordPattern = Pattern.compile(passwordRegex)
        val matcher = passWordPattern.matcher(password)
        return matcher.find() // required form client
    }

    fun validatePhone(phone:String):Boolean= (phone.startsWith("010") || phone.startsWith("011") || phone.startsWith("012") || phone.startsWith("015")) && phone.length == 11
}