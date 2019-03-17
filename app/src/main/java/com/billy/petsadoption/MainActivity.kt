package com.billy.petsadoption

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Pet().getDogs(object : Pet.CallBack {
            override fun onFinish(list: ArrayList<Pet>) {
                Log.i(TAG, "${list.size}")
            }
        })

        Pet().getCats(object : Pet.CallBack {
            override fun onFinish(list: ArrayList<Pet>) {
                Log.i(TAG, "${list.size}")
            }
        })


        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setupViewPager(viewPager: ViewPager) {
        var dogFragment = DogFragment()
        var catFragment = PetFragment()

        var adapter = SectionPageAdapter(supportFragmentManager)
        adapter.addFragment(dogFragment, "狗")
        adapter.addFragment(catFragment, "貓")
        viewPager.adapter = adapter
    }
}
