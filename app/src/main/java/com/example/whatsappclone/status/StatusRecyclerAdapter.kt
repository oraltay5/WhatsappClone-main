package com.example.whatsappclone.status

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R

class StatusRecyclerAdapter(
    private val item: List<Status>,
    private val onItemClickListener: (String) -> Unit

) : RecyclerView.Adapter<StatusRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_status, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var statusNameTextView: TextView
        lateinit var msgTextView: TextView
        lateinit var avatarView: ImageView
        lateinit var dateTextView: TextView
        lateinit var itemViewGroup: RelativeLayout

        fun bind(item: Status){
            statusNameTextView = itemView.findViewById(R.id.statusNameTextView)
            msgTextView = itemView.findViewById(R.id.checkTextView)
            avatarView = itemView.findViewById(R.id.statusAvatarView)
            dateTextView = itemView.findViewById(R.id.timeTextView)
            itemViewGroup = itemView.findViewById(R.id.itemStatusViewGroup)

            statusNameTextView.text = item.name
            msgTextView.text = item.demoText
            dateTextView.text = item.date

            avatarView.setImageDrawable(
                ContextCompat.getDrawable(itemView.context, item.avatar)
            )

            itemViewGroup.setOnClickListener {
                onItemClickListener(item.name)
            }
        }
    }
}