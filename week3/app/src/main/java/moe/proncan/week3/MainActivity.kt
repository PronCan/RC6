package moe.proncan.week3

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//import moe.proncan.week3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
//    lateinit var mainBinding: ActivityMainBinding
    lateinit var mainItemAdapter: MainItemAdapter
    private val list = mutableListOf<MainItemData>()
    lateinit var mainRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainRecyclerView = findViewById(R.id.main_recycler_view)

        init()
    }

    private fun init() {
        mainItemAdapter = MainItemAdapter(this)
        val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mainRecyclerView.layoutManager = linearLayoutManager
        mainRecyclerView.adapter = mainItemAdapter

        list.apply {
            add(MainItemData(img = R.drawable.main1, title = "1번상품", area = "운서동", time = "3분전"
                , price = "35,000", chatCnt = "", chatImg = R.drawable.ic_temp
                , likeCnt = "2", likeImg = R.drawable.ic_temp ))
            add(MainItemData(img = R.drawable.main2, title = "2번상품", area = "운서동", time = "3분전"
                , price = "35,000", chatCnt = "3", chatImg = R.drawable.ic_temp
                , likeCnt = "0", likeImg = R.drawable.ic_temp ))

            mainItemAdapter.list = list
            Log.d(TAG, "maininitfun "+ mainItemAdapter.itemCount)
            mainItemAdapter.notifyDataSetChanged()
        }
    }
}