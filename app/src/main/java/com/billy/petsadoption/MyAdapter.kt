package com.billy.petsadoption

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.billy.petsadoption.databinding.ItemPetsBinding

class MyAdapter: RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private var list: List<Pet>

    constructor(list: List<Pet>) {
        this.list = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = DataBindingUtil.inflate<ItemPetsBinding>(LayoutInflater.from(parent.context),
                                                                            R.layout.item_pets,
                                                                            parent,
                                                                            false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.pet = list.get(position)
    }

    class ViewHolder: RecyclerView.ViewHolder {
        var binding: ItemPetsBinding
            get() = field
            set(value) { field = value }

        constructor(binding: ItemPetsBinding): super(binding.root) {
            this.binding = binding
        }

    }
}