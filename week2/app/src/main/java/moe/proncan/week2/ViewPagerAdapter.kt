package moe.proncan.week2

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
//import moe.proncan.week2.databinding.ActivityFirstInfoBinding

//import first_info_list_item

class ViewPagerAdapter : PagerAdapter() {
    private var mContext: Context? = null

    fun ViewPagerAdapter(context: Context) {
        mContext = context
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.first_info_list_item, false)
        view.firstViewInfo
    }
}