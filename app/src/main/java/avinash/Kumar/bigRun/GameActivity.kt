package avinash.Kumar.bigRun

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT = 3000L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        Handler().postDelayed(
            {
                val i = Intent(this@GameActivity, MainScreen::class.java)
                startActivity(i)
                finish()
            }, SPLASH_TIME_OUT
        )
    }
}