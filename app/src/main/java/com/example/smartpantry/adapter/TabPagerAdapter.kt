package com.example.smartpantry.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.smartpantry.ui.DespensaFragment
import com.example.smartpantry.ui.GeladeiraFragment
import com.example.smartpantry.ui.InicioFragment

private const val NUM_TABS = 3

class TabPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle){

    override fun getItemCount(): Int {
      return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> InicioFragment()
            1 -> GeladeiraFragment()
            3 -> DespensaFragment()
            else -> InicioFragment()
        }
    }


}