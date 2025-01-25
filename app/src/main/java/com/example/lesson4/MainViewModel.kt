package com.example.lesson4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lesson4.data.RetrofitInstance
import com.example.lesson4.data.model.BaseResponce
import com.example.lesson4.data.model.Character // Импорт вашего класса Character
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val _charactersLiveData = MutableLiveData<List<Character>>()
    val charactersLiveData: LiveData<List<Character>> get() = _charactersLiveData

    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    private val api = RetrofitInstance.api

    fun getCharacters() {
        api.getCharacters().enqueue(object : Callback<BaseResponce> {
            override fun onResponse(call: Call<BaseResponce>, response: Response<BaseResponce>) {
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.characters?.let {
                        _charactersLiveData.postValue(it)
                    }
                } else {
                    _errorLiveData.postValue("Response not successful")
                }
            }

            override fun onFailure(call: Call<BaseResponce>, t: Throwable) {
                _errorLiveData.postValue(t.message ?: "Unknown error")
            }
        })
    }
}
