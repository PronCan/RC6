package moe.proncan.week3

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

//import moe.proncan.week3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
//    lateinit var mainBinding: ActivityMainBinding
    lateinit var mainItemAdapter: MainItemAdapter
    private val list = mutableListOf<MainItemData>()

    lateinit var mainRecyclerView: RecyclerView
    val bottomNavigationView: BottomNavigationView by lazy {
        findViewById(R.id.main_bottom_navigation_view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
//        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainRecyclerView = findViewById(R.id.main_recycler_view)

        init()
        initFragment()
    }

    private fun init() {
        mainItemAdapter = MainItemAdapter(this)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mainRecyclerView.layoutManager = linearLayoutManager
        mainRecyclerView.adapter = mainItemAdapter
        // 구분선 추가
        val dividerItemDecoration = DividerItemDecoration(mainRecyclerView.context, LinearLayoutManager(this).orientation)
        mainRecyclerView.addItemDecoration(dividerItemDecoration)

        list.apply {
            add(MainItemData(img = R.drawable.main1, title = "당근캐리어", area = "운서동", time = "3분전"
                , price = "35,000", chatCnt = "0", chatImg = R.drawable.ic_chat
                , likeCnt = "2", likeImg = R.drawable.ic_like ))
            add(MainItemData(img = R.drawable.main2, title = "삼성VR", area = "중산동", time = "1시간전"
                , price = "24,000", chatCnt = "3", chatImg = R.drawable.ic_chat
                , likeCnt = "0", likeImg = R.drawable.ic_like ))
            add(MainItemData(img = R.drawable.main3, title = "서큘레이터", area = "영종1동", time = "끌올 1일전"
                , price = "20,000", chatCnt = "3", chatImg = R.drawable.ic_chat
                , likeCnt = "0", likeImg = R.drawable.ic_like ))
            add(MainItemData(img = R.drawable.main4, title = "포켓몬 빵 팔아요", area = "운서동", time = "4시간전"
                , price = "4,000", chatCnt = "3", chatImg = R.drawable.ic_chat
                , likeCnt = "0", likeImg = R.drawable.ic_like ))
            add(MainItemData(img = R.drawable.main5, title = "오래된 무전기", area = "운남동", time = "8시간전"
                , price = "10,000", chatCnt = "3", chatImg = R.drawable.ic_chat
                , likeCnt = "0", likeImg = R.drawable.ic_like ))

            mainItemAdapter.list = list
            Log.d(TAG, "maininitfun "+ mainItemAdapter.itemCount)
            mainItemAdapter.notifyDataSetChanged()
        }
//        for (i: Int in 1..list.size){
//            if(list[i].chatCnt == "0") {
//                list[i].chatCnt
//            }
//        }

    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction().add(bottomNavigationView.id, MainFragment()).commit()


    }

}