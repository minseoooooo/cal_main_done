package com.example.solutionchallenge.adapter

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.solutionchallenge.fragment.PersonalFrame
import com.example.solutionchallenge.fragment.TodayFrame


class SlidingAdapter(fa: FragmentActivity?, var mCount: Int) : FragmentStateAdapter(fa!!) {

    private var personalFrameClickListener: (() -> Unit)? = null
    private var todayFrameClickListener: (() -> Unit)? = null

    fun setOnPersonalFrameClickListener(listener: () -> Unit) {
        personalFrameClickListener = listener
    }

    fun setOnTodayFrameClickListener(listener: () -> Unit) {
        todayFrameClickListener = listener
    }

    @NonNull
    override fun createFragment(position: Int): Fragment {
        return when (getRealPosition(position)) {
            0 -> PersonalFrame()
            1 -> TodayFrame()
            else -> throw IllegalArgumentException("Invalid position $position")
        }
    }

    override fun getItemCount(): Int {
        return 1000
    }

    fun getRealPosition(position: Int): Int {
        return position % mCount
    }
}