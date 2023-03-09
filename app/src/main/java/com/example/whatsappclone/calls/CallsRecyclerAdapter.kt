package com.example.whatsappclone.calls

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.Calls
import com.example.whatsappclone.R

class CallsRecyclerAdapter(
    private val item: List<Calls>,
    private val onItemClickListener: (Calls) -> Unit
) : RecyclerView.Adapter<CallsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_calls, parent, false)
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

        fun bind(item: Calls){
            nameTextView = itemView.findViewById(R.id.callsNameTextView)
            msgTextView = itemView.findViewById(R.id.callMsgTextView)
            avatarView = itemView.findViewById(R.id.callAvatarView)
            dateTextView = itemView.findViewById(R.id.callDateTextView)
            itemViewGroup = itemView.findViewById(R.id.itemCallsViewGroup)

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