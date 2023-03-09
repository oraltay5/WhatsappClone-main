package com.example.whatsappclone.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsappclone.R

class MusicRecyclerAdapter(
    private val item: List<Music>,
    private val onItemClickListener: (Music) -> Unit
) : RecyclerView.Adapter<MusicRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_music, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var musicNameTextView: TextView
        lateinit var artistTextView: TextView
        lateinit var labelImageView: AppCompatImageView
        lateinit var timeTextView: TextView
        lateinit var itemViewGroup: RelativeLayout

        fun bind(item: Music) {
            musicNameTextView = itemView.findViewById(R.id.musicNameText)
            artistTextView = itemView.findViewById(R.id.ispolnotelText)
            labelImageView = itemView.findViewById(R.id.labelView)
            timeTextView = itemView.findViewById(R.id.timeText)
            itemViewGroup = itemView.findViewById(R.id.itemViewGroup)

            musicNameTextView.text = item.musicName
            artistTextView.text = item.artistName
            timeTextView.text = item.time

            Glide
                .with(itemView)
                .load(item.labelImage)
                .centerCrop()
                .placeholder(R.drawable.ic_default)
                .into(labelImageView)

            itemViewGroup.setOnClickListener {
                onItemClickListener(item)
            }
        }
    }
}