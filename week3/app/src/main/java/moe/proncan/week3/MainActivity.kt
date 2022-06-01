package moe.proncan.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import moe.proncan.week3.databinding.ActivityMainBinding

lateinit var mainBinding: ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainItemAdapter: MainItemAdapter
    val list = mutableListOf<MainItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        mainItemAdapter = MainItemAdapter(this)
        mainBinding.mainRecyclerView.adapter = mainItemAdapter

        list.apply {
            add(MainItemData(img = R.drawable.main1, title = "1번상품", area = "운서동", time = "3분전"
                , price = "35000", chatCnt = "", chatImg = R.drawable.ic_temp
                , likeCnt = "2", likeImg = R.drawable.ic_temp ))
            add(MainItemData(img = R.drawable.main2, title = "2번상품", area = "운서동", time = "3분전"
                , price = "35000", chatCnt = "3", chatImg = R.drawable.ic_temp
                , likeCnt = "0", likeImg = R.drawable.ic_temp ))
        }
    }
}