package com.taek.mvvm_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.taek.mvvm_practice.databinding.ActivityMainBinding

// Controller
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var viewModel = ViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        viewModel.toastMessage.observe(this, Observer {
            Toast.makeText(this, "$it 번을 클릭했습니다.", Toast.LENGTH_SHORT).show()
        })

        viewModel.checkPasswordMessage.observe(this, Observer {
            if (viewModel.checkPasswordMessage.value == true) {
                binding.messageSuccess.visibility = View.VISIBLE
            } else {
                binding.messageSuccess.visibility = View.GONE
            }
        })
    }
}