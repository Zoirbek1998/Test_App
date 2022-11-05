package dev.future.testapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import dev.future.testapp.databinding.ActivityTimePickerBinding
import java.util.*
import kotlin.math.min

class TimePickerActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {
    lateinit var binding: ActivityTimePickerBinding

    var day = 0
    var month = 0
    var year = 0
    var hour = 0
    var minute = 0


    var saveDay = 0
    var saveMonth = 0
    var saveYear = 0
    var saveHour = 0
    var saveMinute = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pickDate()


    }

    private fun pickDate() {
        binding.btnTimePicker.setOnClickListener {
            getDateTimePickCalendar()

            DatePickerDialog(this, this, year, month, day).show()
        }
    }

    private fun getDateTimePickCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        saveDay = dayOfMonth
        saveMonth = month
        saveYear = year
        getDateTimePickCalendar()
        TimePickerDialog(this,this,hour,minute,true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        saveMinute = minute
        saveHour = hourOfDay

        binding.tvTime.text ="$saveDay-$saveMonth-$saveYear ,\n $saveHour Minute: $saveMinute"
    }

}