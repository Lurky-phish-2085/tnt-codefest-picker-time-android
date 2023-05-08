package xyz.lurkyphish2085.timepickerdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.min

class SharedViewModel : ViewModel() {

    private var _time = MutableLiveData<String>()
    val time: LiveData<String> = _time

    fun changeTime(hour: Int, minute: Int) {
        val hour = hour.toString()
        val minute = when (minute) {
            0 -> "00"
            else -> minute.toString()
        }

        _time.value = "$hour:$minute"
    }
}