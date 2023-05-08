package xyz.lurkyphish2085.timepickerdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import xyz.lurkyphish2085.timepickerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        viewModel.time.observe(this) {
            binding.time.text = it
        }

        binding.editTimeBtn.setOnClickListener {
            TimePickerFragment(viewModel).show(supportFragmentManager, "timePicker")
        }
    }
}