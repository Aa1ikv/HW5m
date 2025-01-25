package com.example.lesson4

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.lesson4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupButtons()
        observeViewModel()
    }



    private fun setupButtons() {
        binding.apply {
            btnIncrement.setOnClickListener { viewModel.onIncrement() }
            btnDecrement.setOnClickListener { viewModel.onDecrement() }

        }
    }
    private fun observeViewModel() {
        viewModel.counterData.observe(this, Observer { model ->
            binding.tvCount.text = model.count.toString()

            binding.tvCount.setTextColor(
                if (model.isGreenText) Color.GREEN else Color.BLACK

            )
            if (model.showCongratulation){
                Toast.makeText(this, "Поздравляем!", Toast.LENGTH_SHORT).show()
                viewModel.congratulationsShown()
            }
        })

    }
}