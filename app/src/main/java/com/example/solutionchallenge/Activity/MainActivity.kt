package com.example.solutionchallenge.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.solutionchallenge.Adapter.SlidingAdapter
import com.example.solutionchallenge.R
import me.relex.circleindicator.CircleIndicator3


class MainActivity : AppCompatActivity() {

    private lateinit var mPager: ViewPager2
    private lateinit var pagerAdapter: FragmentStateAdapter
    private var num_page = 2
    private lateinit var mIndicator: CircleIndicator3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPager = findViewById(R.id.viewpager)
        pagerAdapter = SlidingAdapter(this, num_page)
        mPager.adapter = pagerAdapter

        mIndicator = findViewById(R.id.indicator)
        mIndicator.setViewPager(mPager)
        mIndicator.createIndicators(num_page, 0)

        mPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        mPager.setCurrentItem(500) //시작 지점
        mPager.offscreenPageLimit = 2 //최대 이미지 수

        mPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                if (positionOffsetPixels == 0) {
                    mPager.setCurrentItem(position, false)
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                mIndicator.animatePageSelected(position % num_page)
            }
        })
    }
}