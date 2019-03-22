package com.billy.petsadoption.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.billy.petsadoption.PetViewModel
import com.billy.petsadoption.R
import com.billy.petsadoption.databinding.FragmentPetsBinding

class DogFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding = DataBindingUtil.inflate<FragmentPetsBinding>(inflater,
            R.layout.fragment_pets, container!!, false)

        PetViewModel(container.context, "dog", binding)

        return binding.root
    }
}