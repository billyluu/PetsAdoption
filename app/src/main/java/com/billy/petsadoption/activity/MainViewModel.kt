package com.billy.petsadoption.activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.view.View
import com.billy.petsadoption.databinding.ActivityMainBinding
import com.billy.petsadoption.model.Pet

class MainViewModel: ViewModel() {

    val startCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val IsLoadingEnd: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun startCount() {
        Pet().getCount(object : Pet.CallBack2{
            override fun getCount(count: Int) {
                startCount.value = count
                IsLoadingEnd.value = true
            }
        })
    }
}