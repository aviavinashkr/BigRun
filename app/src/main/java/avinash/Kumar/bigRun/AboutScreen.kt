package avinash.Kumar.bigRun

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_about_screen.*
import kotlinx.android.synthetic.main.activity_about_screen.backBtn
import kotlinx.android.synthetic.main.activity_main.*

class AboutScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_screen)

        gitHubLogo.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/aviavinashkr"))
            startActivity(i)
        }
        twitterLogo.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/aviavinashkravi"))
            startActivity(i)
        }
        backBtn.setOnClickListener {
            val intent = Intent(this,MainScreen::class.java)
            startActivity(intent)
        }
    }
}