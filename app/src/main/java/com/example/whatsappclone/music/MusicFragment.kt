package com.example.whatsappclone.music

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.music.detail.MusicDetailActivity
import kotlinx.android.parcel.Parcelize

class MusicListFragment: Fragment(R.layout.fragment_music) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = MusicRecyclerAdapter(
            item = getMusicSampleData(),
            onItemClickListener = { music ->
                val intent = Intent(activity, MusicDetailActivity::class.java)
                intent.putExtra("ARG_MUSIC", music)
                startActivity(intent)
            }
        )
    }


    private fun getMusicSampleData() = mutableListOf<Music>().apply {
        (1..20).forEach { index ->
            if (index == 2) {
                add(
                    Music(
                        musicName = "Music $index",
                        artistName = "Pop",
                        time = "01:56",
                        labelImage = "https://yt3.googleusercontent.com/vCqmJ7cdUYpvR0bqLpWIe8ktaor4QafQLlfQyTuZy-M9W_YafT8Wo9kdsKL2St1BrkMRpVSJgA=s900-c-k-c0x00ffffff-no-rj"
                    )
                )
            } else if (index > 2) {
                add(
                    Music(
                        musicName = "Music $index",
                        artistName = "Rock",
                        time = "01:56",
                        labelImage = "https://yt3.googleusercontent.com/vCqmJ7cdUYpvR0bqLpWIe8ktaor4QafQLlfQyTuZy-M9W_YafT8Wo9kdsKL2St1BrkMRpVSJgA=s900-c-k-c0x00ffffff-no-rj"
                    )
                )
            } else {
                add(
                    Music(
                        musicName = "Music $index",
                        artistName = "Jazz",
                        time = "01:56",
                        labelImage = "https://yt3.googleusercontent.com/vCqmJ7cdUYpvR0bqLpWIe8ktaor4QafQLlfQyTuZy-M9W_YafT8Wo9kdsKL2St1BrkMRpVSJgA=s900-c-k-c0x00ffffff-no-rj"
                    )
                )
            }
        }
    }
}

@Parcelize
data class Music(
    val musicName: String,
    val artistName: String,
    val time: String,
    val labelImage: String
): Parcelable