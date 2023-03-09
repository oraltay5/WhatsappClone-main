package com.example.whatsappclone.chats

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsappclone.Chats
import com.example.whatsappclone.R

class ChatRecyclerAdapter(
    private val item: List<Chats>,
    private val onItemClickListener: (Chats) -> Unit,
) : RecyclerView.Adapter<ChatRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var nameTextView: TextView
        lateinit var msgTextView: TextView
        lateinit var avatarView: ImageView
        lateinit var dateTextView: TextView
        lateinit var itemViewGroup: RelativeLayout


        fun bind(item: Chats){
            nameTextView = itemView.findViewById(R.id.nameTextView)
            msgTextView = itemView.findViewById(R.id.msgTextView)
            avatarView = itemView.findViewById(R.id.avatarView)
            dateTextView = itemView.findViewById(R.id.dateTextView)
            itemViewGroup = itemView.findViewById(R.id.itemViewGroup)


            nameTextView.text = item.name
            msgTextView.text = item.demoText
            dateTextView.text = item.date

//            avatarView.setImageDrawable(
//                ContextCompat.getDrawable(itemView.context, item.avatar)
//            )

            Glide
                .with(itemView)
                .load(item.avatar)
                .centerCrop()
                .placeholder(R.drawable.ic_default)
                .into(avatarView)

            itemViewGroup.setOnClickListener {
                onItemClickListener(item)
            }
        }
    }
}