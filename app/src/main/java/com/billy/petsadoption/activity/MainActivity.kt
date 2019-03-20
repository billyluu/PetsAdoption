package com.billy.petsadoption.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import com.billy.petsadoption.R
import com.billy.petsadoption.adapter.SectionPageAdapter
import com.billy.petsadoption.fragment.CatFragment
import com.billy.petsadoption.fragment.DogFragment
import com.billy.petsadoption.model.Pet
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.counter_view.*

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)

        Pet().getCount(object : Pet.CallBack2{
            override fun getCount(count: Int) {
                counter.visibility = View.VISIBLE
                counter.startValue = 0
                counter.endValue = count
                counter.startCount()
            }
        })

    }

    private fun setupViewPager(viewPager: ViewPager) {
        var dogFragment = DogFragment()
        var catFragment = CatFragment()

        var adapter = SectionPageAdapter(supportFragmentManager)
        adapter.addFragment(dogFragment, "狗")
        adapter.addFragment(catFragment, "貓")
        viewPager.adapter = adapter
    }
}
