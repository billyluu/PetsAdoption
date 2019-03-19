package com.billy.petsadoption

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.util.Log
import com.billy.petsadoption.adapter.MyAdapter
import com.billy.petsadoption.databinding.FragmentPetsBinding
import com.billy.petsadoption.model.Pet
import com.billy.petsadoption.view.ProgressView
import org.jetbrains.anko.runOnUiThread

class PetViewModel(var context: Context, var type: String, var binding: FragmentPetsBinding): ViewModel() {


    //private var progressView: ProgressView
    init {
//        progressView = ProgressView(context)
//        progressView.setMessage("請稍候...")
//        progressView.show()
        createAdapter()

    }

    private fun createAdapter() {
        if (type.equals("cat")) {
            Pet().getCats(object : Pet.CallBack {
                override fun onFinish(list: ArrayList<Pet>) {
                    var adapter = MyAdapter(context, list)
                    context.runOnUiThread {
                        binding.adapter = adapter
                        //progressView.close()
                    }
                }
            })
        }

        if (type.equals("dog")) {
            Pet().getDogs(object : Pet.CallBack {
                override fun onFinish(list: ArrayList<Pet>) {
                    var adapter = MyAdapter(context, list)
                    context.runOnUiThread {
                        binding.adapter = adapter
                        //progressView.close()
                    }
                }
            })
        }


    }
}