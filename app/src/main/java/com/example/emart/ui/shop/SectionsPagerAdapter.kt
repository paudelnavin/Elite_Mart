package com.example.emart.ui.shop

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.emart.R
import com.example.emart.ui.categories.ElectronicsFragment

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> ElectronicsFragment.newInstance()
            else -> ElectronicsFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Electronics"
            1 -> "Clothes"
            2 -> "Beauty"
            3 -> "Food"
            else -> "Electronics"
        }
    }

    override fun getCount(): Int {
        return 4
    }
}
