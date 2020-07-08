package avinash.Kumar.bigRun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)


        playBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        aboutBtn.setOnClickListener {
            val intent = Intent(this, AboutScreen::class.java)
            startActivity(intent)
        }
        backBtn.setOnClickListener {
            showFilterDialog()
        }
        exitBtn.setOnClickListener {
            showFilterDialog()

        }
    }
        private fun showFilterDialog(){
            val dialog = MaterialDialog(this)
                .noAutoDismiss()
                .customView(R.layout.layout_dialog)
            dialog.findViewById<TextView>(R.id.positive_button).setOnClickListener {
               moveTaskToBack(true)
                android.os.Process.killProcess(android.os.Process.myPid())
                System.exit(1)
                dialog.dismiss()
            }
            dialog.findViewById<TextView>(R.id.negative_button).setOnClickListener {
                val intent = Intent(this, MainScreen::class.java)
                startActivity(intent)
                dialog.dismiss()
            }
            dialog.show ()

        }
}