package com.billy.petsadoption.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.billy.petsadoption.model.Pet
import com.billy.petsadoption.R
import com.billy.petsadoption.adapter.SectionPageAdapter
import com.billy.petsadoption.fragment.PetFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        var dogFragment = PetFragment()
        var catFragment = PetFragment()

        var adapter = SectionPageAdapter(supportFragmentManager)
        adapter.addFragment(dogFragment, "貓")
        adapter.addFragment(catFragment, "狗")
        viewPager.adapter = adapter
    }
}
