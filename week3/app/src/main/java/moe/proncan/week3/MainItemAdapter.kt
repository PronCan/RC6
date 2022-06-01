package moe.proncan.week3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainItemAdapter(private val context: Context): RecyclerView.Adapter<MainItemAdapter.ViewHolder> {

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
        private val ivItemImg: TextView = itemView.findViewById(R.id.item_main_image)
        private val tvTitle: TextView = itemView.findViewById(R.id.item_main_title)
        private val tvArea: TextView = itemView.findViewById(R.id.item_main_area)
        private val tvTime: TextView = itemView.findViewById(R.id.item_main_time)
        private val tvPrice: TextView = itemView.findViewById(R.id.item_main_price)
        // 0이면 안보이게
        private val tvLikeCount: TextView = itemView.findViewById(R.id.item_main_chat_count)
        private val ivLikeCount: TextView = itemView.findViewById(R.id.item_main_chat)
        private val tvChatCount: TextView = itemView.findViewById(R.id.item_main_like_count)
        private val ivChatCount: TextView = itemView.findViewById(R.id.item_main_like)

        // 바인딩
        // 이미지 바인딩 Glide 사용
        fun _binding(item: MainItemData) {

            ivItemImg
            tvTitle
            tvArea
            tvTime
            tvPrice

            tvLikeCount
            ivLikeCount
            tvChatCount
            ivChatCount
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