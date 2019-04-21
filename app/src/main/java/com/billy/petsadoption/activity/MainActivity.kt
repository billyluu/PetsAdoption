package com.billy.petsadoption.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.Observable
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
import com.billy.petsadoption.databinding.ActivityMainBinding
import com.billy.petsadoption.view.ProgressView


class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    private lateinit var binding: ActivityMainBinding
    private lateinit var progressView: ProgressView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setProgress()
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        setCount()

        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)
        setPageChangeListener()
    }

    private fun setCount() {
        getViewModel().startCount()

        getViewModel().IsLoadingEnd.observe(this, Observer {
            if (it!!) {
                progressView.close()
            }
        })
        getViewModel().startCount.observe(this, Observer {
            binding.counter.visibility = View.VISIBLE
            binding.counter.startValue = 0
            binding.counter.endValue = it!!
            binding.counter.startCount()
        })
    }

    private fun setProgress() {
        progressView = ProgressView(this)
        progressView.setMessage("請稍候...")
        progressView.show()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        var dogFragment = DogFragment()
        var catFragment = CatFragment()

        var adapter = SectionPageAdapter(supportFragmentManager)
        adapter.addFragment(dogFragment, "狗")
        adapter.addFragment(catFragment, "貓")
        viewPager.adapter = adapter

    }

    private fun setPageChangeListener() {
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
                when(p0) {
                    0 -> {
                        pet_kind.text = "狗"
                    }

                    1 -> {
                        pet_kind.text = "貓"
                    }
                }
            }

            override fun onPageSelected(p0: Int) {
                when(p0) {
                    0 -> {
                        pet_kind.text = "狗"
                    }

                    1 -> {
                        pet_kind.text = "貓"
                    }
                }
            }
        })
    }

    private fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, MainViewModelFactory()).get(MainViewModel::class.java)
    }
}
