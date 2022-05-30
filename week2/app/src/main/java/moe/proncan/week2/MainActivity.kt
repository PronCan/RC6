package moe.proncan.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import moe.proncan.week2.databinding.ActivityFirstInfoBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstInfoBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_first_info)
        setContentView(binding.root)
        binding.sliderFirstInfo.adapter = ViewPagerAdapter(getSliderFirstInfo())
        binding.sliderFirstInfo.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun getSliderFirstInfo(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.first_info_1, R.drawable.first_info_2, R.drawable.first_info_3, R.drawable.first_info_4
                , R.drawable.first_info_5, R.drawable.first_info_6)
    }
}