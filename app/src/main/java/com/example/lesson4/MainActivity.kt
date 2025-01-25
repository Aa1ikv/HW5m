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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lesson4.data.CartoonAdapter
import com.example.lesson4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getCharacters()
        setupRecyclerView()

        viewModel.charactersLiveData.observe(this){
            data -> //adapter.putList(data)
        }
    }
    private fun setupRecyclerView() = with(binding.rvCharacter){
         layoutManager= LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        adapter = CartoonAdapter
    }

}