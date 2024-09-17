package com.example.mvvm

import android.graphics.Color
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val model = CounterModel()

    val counterData = MutableLiveData<Int>()
    val toastMessage = MutableLiveData<String>()
    val textColor = MutableLiveData<Int>()

    private fun updateCounter() {
        counterData.value = model.count

        when (model.count) {
            10 -> toastMessage.value = "Поздравляем!"
            15 -> textColor.value = Color.GREEN
            else -> textColor.value = Color.BLACK
        }
    }

    fun increment(){
        model.increment()
        counterData.value = model.count
        updateCounter()

    }

    fun decrement(){
        model.decrement()
       counterData.value = model.count
        updateCounter()
    }

}