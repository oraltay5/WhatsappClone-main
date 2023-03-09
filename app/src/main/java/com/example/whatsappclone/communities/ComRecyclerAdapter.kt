package com.example.whatsappclone.communities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.Groups
import com.example.whatsappclone.R

class ComRecyclerAdapter(
    private val item: List<Groups>,
    private val onItemClickListener: (Groups) -> Unit
) : RecyclerView.Adapter<ComRecyclerAdapter.ViewHolder>() {

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

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var nameTextView: TextView
        lateinit var msgTextView: TextView
        lateinit var avatarView: AppCompatImageView
        lateinit var dateTextView: TextView
        lateinit var itemViewGroup: RelativeLayout

        fun bind(item: Groups){
            nameTextView = itemView.findViewById(R.id.comNameTextView)
            msgTextView = itemView.findViewById(R.id.comMsgTextView)
            avatarView = itemView.findViewById(R.id.comAvatarView)
            dateTextView = itemView.findViewById(R.id.comDateTextView)
            itemViewGroup = itemView.findViewById(R.id.itemViewComGroup)

            nameTextView.text = item.name
            msgTextView.text = item.demoText
            dateTextView.text = item.date

            avatarView.setImageDrawable(
                ContextCompat.getDrawable(itemView.context, item.avatar)
            )

            itemViewGroup.setOnClickListener {
                onItemClickListener(item)

            }

        }
    }
}