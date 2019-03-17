package com.billy.petsadoption

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.billy.petsadoption.databinding.FragmentPetsBinding

class PetFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding = DataBindingUtil.inflate<FragmentPetsBinding>(inflater, R.layout.fragment_pets, container, false)
        PetViewModel(container!!.context, binding)


        return binding.root
    }
}