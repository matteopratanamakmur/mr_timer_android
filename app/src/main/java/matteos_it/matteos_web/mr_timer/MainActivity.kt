package matteos_it.matteos_web.mr_timer

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val startMs = 30000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTimerTextView: TextView = findViewById(R.id.timer_text)
        val mStartButton: Button = findViewById(R.id.start_button)
        val mStopButton: Button = findViewById(R.id.stop_button)
        val mResetButton: Button = findViewById(R.id.reset_button)

        // timer
        val mTimer = object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimerTextView.text = "seconds remaining: " + millisUntilFinished / 1000
            }

            override fun onFinish() {
                mTimerTextView.text = "done!"
            }
        }

        // button にイベントを設定
        mStartButton.setOnClickListener {
            mTimer.start()
        }

        // button にイベントを設定
        mResetButton.setOnClickListener {
            mTimer.cancel()
            mTimerTextView.text = "timer"
        }
    }
}