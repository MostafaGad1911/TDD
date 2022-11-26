package mostafagad.projects.tdd.utils

import java.util.regex.Pattern

object LoginValidator {
    fun validatePassword(password:String):Boolean{
        return password.length >= 8 // required form client
    }

    fun validatePhone(phone:String):Boolean= (phone.startsWith("010") || phone.startsWith("011") || phone.startsWith("012") || phone.startsWith("015")) && phone.length == 11
}