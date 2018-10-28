package com.example.root.submission2.View.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.root.submission2.View.Fragment.FragmentLastMatchLeague
import com.example.root.submission2.View.Fragment.FragmentNextMatchLeague

class FragmentAdapter(fragment: FragmentManager) : FragmentPagerAdapter(fragment) {
    override fun getItem(p0: Int): Fragment? = when (p0) {
        0 -> FragmentLastMatchLeague.newInstance()
        1 -> FragmentNextMatchLeague.newInstance()
        else->null
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Last Match"
            1 -> "Next Match"
            else->""
        }

    }

    override fun getCount(): Int =2


}