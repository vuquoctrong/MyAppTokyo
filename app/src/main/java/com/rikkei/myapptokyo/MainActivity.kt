package com.rikkei.myapptokyo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.rikkei.myapptokyo.fragment.BrowseFragment
import com.rikkei.myapptokyo.fragment.HomeFragment
import com.rikkei.myapptokyo.fragment.MyPageFragment
import com.rikkei.myapptokyo.fragment.NearFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private var homeFragment: HomeFragment? = null
    private var  browseFragment: BrowseFragment? = null
    private var myPageFragment: MyPageFragment? = null
    private var nearFragment: NearFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        viewPager.adapter = mSectionsPagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(viewPager))
        homeFragment = HomeFragment()
        browseFragment = BrowseFragment()
        myPageFragment = MyPageFragment()
        nearFragment = NearFragment()


    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            return when (position) {
                0 -> homeFragment
                1 -> nearFragment
                2 -> browseFragment
                3 -> myPageFragment
                else -> null
            }
        }

        override fun getCount(): Int {
            return 4
        }
    }
}
