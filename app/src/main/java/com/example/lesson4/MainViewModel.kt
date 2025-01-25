package com.example.lesson4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _counterData = MutableLiveData(CounterModel(0))
    val counterData: LiveData<CounterModel> = _counterData

    fun onIncrement() {
        val currentCount = counterData.value?.count ?: 0
        val newCount = currentCount + 1

        _counterData.value = CounterModel(
            count = newCount,
            isGreenText = newCount  == 15,
            showCongratulation = newCount == 10

        )

    }
    fun onDecrement() {
        val currentCount = counterData.value?.count ?: 0
        val newCount = currentCount - 1
        _counterData.value = CounterModel(
            count = newCount,
            isGreenText = newCount == 15,
            showCongratulation = newCount == 10
        )
    }
    fun congratulationsShown(){
        _counterData.value = counterData.value?.copy(showCongratulation = false)

    }
}