package com.billy.petsadoption

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.billy.petsadoption.adapter.MyAdapter
import com.billy.petsadoption.databinding.FragmentPetsBinding
import com.billy.petsadoption.model.Pet

class PetViewModel(var context: Context, var binding: FragmentPetsBinding): ViewModel() {

    init {
        setAdapter()
    }

    private fun setAdapter() {

        Pet().getCats(object : Pet.CallBack{
            override fun onFinish(list: ArrayList<Pet>) {
                var adapter = MyAdapter(context, list)
                binding.adapter = adapter
            }
        })

        Pet().getDogs(object : Pet.CallBack{
            override fun onFinish(list: ArrayList<Pet>) {
                var adapter = MyAdapter(context, list)
                binding.adapter = adapter
            }
        })
    }


}