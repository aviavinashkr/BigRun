package avinash.Kumar.bigRun

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    var score: Int = 0
    var imageViewArray = ArrayList<ImageView>()
    var gamehandler: Handler = Handler()
    var runnable: Runnable = Runnable { }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        score = 0

        imageViewArray = arrayListOf(
            imageView1,
            imageView2,
            imageView3,
            imageView4,
            imageView5,
            imageView6,
            imageView7,
            imageView8,
            imageView9
        )

        ImageHide()
        object : CountDownTimer(30000, 1000) {
            override fun onFinish() {
                TimeTxt.text = "Time Over"
                gamehandler.removeCallbacks(runnable)
                for (image in imageViewArray) {
                    image.visibility = View.INVISIBLE
                    retryBtn.visibility = View.VISIBLE
                }

            }


            override fun onTick(millisUntilFinished: Long) {
                TimeTxt.text = "Time: " + millisUntilFinished / 1000
            }
        }.start()

        backBtn.setOnClickListener {
            val intent = Intent(this,MainScreen::class.java)
            startActivity(intent)
        }

        retryBtn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }


    fun ImageHide() {
        runnable = object : Runnable {
            override fun run() {
                for (image in imageViewArray) {
                    image.visibility = View.INVISIBLE
                }
                val random = Random()
                val index = random.nextInt(8 - 0)
                imageViewArray[index].visibility = View.VISIBLE
                gamehandler.postDelayed(runnable, 450)
            }

        }
        gamehandler.post(runnable)

    }
    fun ScoreIncrease(view:View) {
        score++
        ScoreTxt.text = "Score:" + score
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }

    }

}