package com.example.umc_flo


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PanelVPAdapter(fragment: Fragment):FragmentStateAdapter(fragment) {
    private val fragmentlist : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int {
        return fragmentlist.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentlist[position]
    }

    fun addFragment(fragment: PanelFragment){
        fragmentlist.add(fragment)
        notifyItemInserted(fragmentlist.size-1)
    }
}