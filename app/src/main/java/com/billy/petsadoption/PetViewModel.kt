package com.billy.petsadoption

import android.arch.lifecycle.ViewModel
import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.billy.petsadoption.adapter.MyAdapter
import com.billy.petsadoption.databinding.FragmentPetsBinding
import com.billy.petsadoption.model.Pet
import com.billy.petsadoption.view.ProgressView
import org.jetbrains.anko.runOnUiThread

class PetViewModel(var context: Context, var type: String, var binding: FragmentPetsBinding): ViewModel() {

    private var PAGE_START = 0
    private var isLoading = false
    private var isLastPage = false
    private var currentPage = PAGE_START
    private var showListCount = 20

    private var startIndex = 0
    private var endIndex = 20


    init {

        createAdapter()

    }

    private fun createAdapter() {
        if (type.equals("cat")) {
            Pet().getCats(object : Pet.CallBack {
                override fun onFinish(list: ArrayList<Pet>) {
                    var adapter = MyAdapter(context, list.subList(startIndex, endIndex))
                    context.runOnUiThread {
                        var layoutManager = GridLayoutManager(context, 2)
                        binding.petsRecyclerView.layoutManager = layoutManager
                        binding.adapter = adapter
                        setPagination(list, layoutManager, adapter)

                    }
                }
            })
        }

        if (type.equals("dog")) {
            Pet().getDogs(object : Pet.CallBack {
                override fun onFinish(list: ArrayList<Pet>) {
                    var adapter = MyAdapter(context, list.subList(startIndex, endIndex))
                    context.runOnUiThread {
                        var layoutManager = GridLayoutManager(context, 2)
                        binding.petsRecyclerView.layoutManager = layoutManager
                        binding.adapter = adapter
                        setPagination(list, layoutManager, adapter)
                    }
                }
            })
        }
    }

    private fun setPagination(list: ArrayList<Pet>, layoutManager: GridLayoutManager, adapter: MyAdapter) {
        binding.petsRecyclerView.addOnScrollListener(object: PaginationScrollListener(layoutManager) {

            override fun loadMoreItems() {
                isLoading = true
                currentPage += 1

                startIndex += showListCount
                endIndex += showListCount
                Log.i("startIndex", "${startIndex}")
                Log.i("endIndex", "${endIndex}")

                adapter.add(list.subList(startIndex, endIndex))

            }

            override var isLastPage: Boolean
                get() = this@PetViewModel.isLastPage
                set(value) {}

            override var isLoading: Boolean
                get() = this@PetViewModel.isLoading
                set(value) {}

            override var totalPageCount: Int
                get() = getPageCount(list.size)
                set(value) {}
        })


    }

    private fun getPageCount(count: Int): Int {
        var result = 0
        if (count % 20 > 0) result = (count / 20) + 1
        else result = count / 20

        return result
    }
}