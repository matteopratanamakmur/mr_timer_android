package matteos_it.matteos_web.mr_timer

import android.annotation.SuppressLint
import android.content.Context
import android.os.*
import android.os.VibrationEffect.DEFAULT_AMPLITUDE
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTimerTextView: TextView = findViewById(R.id.timer_text)
        val mStartButton: Button = findViewById(R.id.start_button)
        val mResetButton: Button = findViewById(R.id.reset_button)
        val mNumberPicker: NumberPicker = findViewById(R.id.number_picker)
        mNumberPicker.minValue = 0
        mNumberPicker.maxValue=99
        mNumberPicker.value=3

        // timer
        val mTimer = object : CountDownTimer(mNumberPicker.value.toLong() * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                mTimerTextView.text = "seconds remaining: " + (millisUntilFinished / 1000)
            }

            override fun onFinish() {
                mTimerTextView.text = "done!"
                val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                val vibrationEffect: VibrationEffect = VibrationEffect.createOneShot(1000, DEFAULT_AMPLITUDE)
                vibrator.vibrate(vibrationEffect)
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