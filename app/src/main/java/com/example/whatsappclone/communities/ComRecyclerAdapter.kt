package com.example.whatsappclone.communities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsappclone.R
import com.example.whatsappclone.database.entities.ChatEntity

class ComRecyclerAdapter(
    private val item: List<ChatEntity>,
    private val onItemClickListener: (ChatEntity) -> Unit
) : RecyclerView.Adapter<ComRecyclerAdapter.ViewHolder>() {

    private val chatItems = mutableListOf<ChatEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_commun, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var nameTextView: TextView
        lateinit var msgTextView: TextView
        lateinit var avatarView: AppCompatImageView
        lateinit var dateTextView: TextView
        lateinit var itemViewGroup: RelativeLayout

        fun bind(item: ChatEntity) {
            nameTextView = itemView.findViewById(R.id.comNameTextView)
            msgTextView = itemView.findViewById(R.id.comMsgTextView)
            avatarView = itemView.findViewById(R.id.comAvatarView)
            dateTextView = itemView.findViewById(R.id.comDateTextView)
            itemViewGroup = itemView.findViewById(R.id.itemViewComGroup)

            nameTextView.text = item.name
            msgTextView.text = item.description

            Glide
                .with(itemView)
                .load("")
                .centerCrop()
                .placeholder(R.drawable.ic_community)
                .into(avatarView)

            itemViewGroup.setOnClickListener {
                onItemClickListener(item)
            }
        }
    }
}