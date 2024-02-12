package com.example.solutionchallenge.Adapter

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.solutionchallenge.PersonalFrame
import com.example.solutionchallenge.TodayFrame


class SlidingAdapter(fa: FragmentActivity?, var mCount: Int) : FragmentStateAdapter(
    fa!!
) {
    @NonNull
    override fun createFragment(position: Int): Fragment {
        val index = getRealPosition(position)
        return if (index == 0) PersonalFrame()  else TodayFrame()
    }

    override fun getItemCount(): Int {
        return 1000
    }

    fun getRealPosition(position: Int): Int {
        return position % mCount
    }
}