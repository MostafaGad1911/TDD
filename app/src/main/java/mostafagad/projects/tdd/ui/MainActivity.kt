package mostafagad.projects.tdd.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import mostafagad.projects.tdd.R
import mostafagad.projects.tdd.databinding.ActivityMainBinding
import mostafagad.projects.tdd.utils.LoginValidator.validatePassword
import mostafagad.projects.tdd.utils.LoginValidator.validatePhone

class MainActivity : AppCompatActivity() , OnClickListener{

    private val mainActivityMainBinding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this , R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityMainBinding.loginBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.loginBtn -> {
                val phone = mainActivityMainBinding.mobileNumberEdt.text.toString()
                val password = mainActivityMainBinding.passwordNumberEdt.text.toString()

                if (!validatePhone(phone = phone)){
                    getString(R.string.invalid_phone).toast()
                    mainActivityMainBinding.mobileNumber.error = getString(R.string.invalid_phone)
                }else if (!validatePassword(password = password)){
                    mainActivityMainBinding.passwordNumber.error = getString(R.string.weak_pass)
                }else{
                    getString(R.string.login_success).toast()
                }
            }
        }
    }

    private fun String.toast(){
        Toast.makeText(applicationContext , this , Toast.LENGTH_LONG).show()
    }
}