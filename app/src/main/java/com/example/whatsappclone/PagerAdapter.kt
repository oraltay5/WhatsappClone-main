package com.example.whatsappclone

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.whatsappclone.music.MusicListFragment
import com.example.whatsappclone.status.StatusFragment

class PagerAdapter(
    lifecycle: Lifecycle,
    fragmentManager: FragmentManager,
): FragmentStateAdapter(fragmentManager, lifecycle) {

    companion object{
        const val PAGE_COUNT = 5
    }

    override fun getItemCount(): Int {
        return PAGE_COUNT
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> ChatsFragment()
            1 -> StatusFragment()
            2 -> CallsFragment()
            3 -> CommunitiesFragment()
            else -> MusicListFragment()
        }
    }
}