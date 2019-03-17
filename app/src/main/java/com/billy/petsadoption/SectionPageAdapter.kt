package com.billy.petsadoption

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class SectionPageAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private var mFragmentList = ArrayList<Fragment>()
    private var mFragmentTitleList = ArrayList<String>()


    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }


    override fun getItem(p0: Int): Fragment = mFragmentList.get(p0)

    override fun getCount(): Int = mFragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = mFragmentTitleList.get(position)


}