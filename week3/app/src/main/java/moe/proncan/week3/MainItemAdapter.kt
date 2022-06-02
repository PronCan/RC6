package moe.proncan.week3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MainItemAdapter(private val context: Context):
    RecyclerView.Adapter<MainItemAdapter.ViewHolder>() {
    // 리스트 개수
    var list = mutableListOf<MainItemData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contents, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder._binding(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val ivItemImg: ImageView = itemView.findViewById(R.id.item_main_image)
        private val tvTitle: TextView = itemView.findViewById(R.id.item_main_title)
        private val tvArea: TextView = itemView.findViewById(R.id.item_main_area)
        private val tvTime: TextView = itemView.findViewById(R.id.item_main_time)
        private val tvPrice: TextView = itemView.findViewById(R.id.item_main_price)
        // 0이면 안보이게 해야함
        private val tvLikeCount: TextView = itemView.findViewById(R.id.item_main_chat_count)
        private val ivLikeCount: ImageView = itemView.findViewById(R.id.item_main_chat)
        private val tvChatCount: TextView = itemView.findViewById(R.id.item_main_like_count)
        private val ivChatCount: ImageView = itemView.findViewById(R.id.item_main_like)

        // 바인딩
        // 이미지 바인딩 Glide 사용
        // 시간 LocalDateTime.now() => 현재시간 https://gdlseed.tistory.com/69
        fun _binding(item: MainItemData) {
            Glide.with(itemView).load(item.img).into(ivItemImg)
            tvTitle.text = item.title
            tvArea.text = item.area
            tvTime.text = item.time
            tvPrice.text = item.price

            tvLikeCount.text = item.likeCnt
            Glide.with(itemView).load(item.likeImg).into(ivLikeCount)
            tvChatCount.text = item.chatCnt
            Glide.with(itemView).load(item.chatImg).into(ivChatCount)
        }

    }
}

data class MainItemData (
    val img: Int,
    val title:String,
    val area:String,
    val time:String,
    val price:String,
    val chatCnt:String,
    val chatImg:Int,
    val likeCnt:String,
    val likeImg:Int

)