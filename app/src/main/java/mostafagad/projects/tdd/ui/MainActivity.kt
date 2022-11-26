package mostafagad.projects.tdd.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import mostafagad.projects.tdd.R
import mostafagad.projects.tdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mainActivityMainBinding:ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(this , R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}