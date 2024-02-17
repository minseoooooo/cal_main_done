package com.myfirstandroidapp.helpcalendar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.solutionchallenge.calendar.CalendarFragment

class ViewPagerAdapter (fragment : FragmentActivity) : FragmentStateAdapter(fragment){


        override fun getItemCount(): Int = 1

        override fun createFragment(position: Int): Fragment {
            return CalendarFragment() //수정전 코드에 왜 CalendarFragment 임포트 안돼있었지?
        }
    }
