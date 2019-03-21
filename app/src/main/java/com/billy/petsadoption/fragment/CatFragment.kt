package com.billy.petsadoption.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.billy.petsadoption.PaginationScrollListener
import com.billy.petsadoption.PetViewModel
import com.billy.petsadoption.R
import com.billy.petsadoption.databinding.FragmentPetsBinding



class CatFragment: Fragment() {
    private val TAG = javaClass.simpleName

    private val isLoading = false
    // 如果当前页面是最后一页（页面加载后分页将停止）
    private val isLastPage = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding = DataBindingUtil.inflate<FragmentPetsBinding>(inflater,
            R.layout.fragment_pets, container, false)
        Log.i(TAG, TAG)
        var layoutManager = GridLayoutManager(container!!.context, 2)
        binding.petsRecyclerView.layoutManager = layoutManager
        binding.petsRecyclerView.addOnScrollListener(object : PaginationScrollListener(layoutManager) {
            override fun loadMoreItems() {

            }

            override val isLastPage: Boolean
                get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

            override val isLoading: Boolean
                get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

            override val totalPageCount: Int
                get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.


        })



        PetViewModel(container.context, "cat", binding)

        return binding.root
    }


}