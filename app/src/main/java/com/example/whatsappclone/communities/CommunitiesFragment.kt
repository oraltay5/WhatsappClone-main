package com.example.whatsappclone

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.chats.detail.ChatDetailActivity
import com.example.whatsappclone.communities.ComRecyclerAdapter
import com.example.whatsappclone.communities.detail.ComDetailActivity
import kotlinx.parcelize.Parcelize

class CommunitiesFragment: Fragment(R.layout.fragment_commun) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = ComRecyclerAdapter(
            item = getComSampleData(),
            onItemClickListener = { group ->
                val intent = Intent(activity, ComDetailActivity::class.java)
                intent.putExtra("ARG_GROUP", group)
                startActivity(intent)
            }
        )
    }

    private fun getComSampleData() = mutableListOf<Groups>().apply {
        (1..3).forEach {index ->
            if(index%2 == 0) {
                add(
                    Groups(
                        name = "Футбол сарапшылары",
                        demoText = "здесь можете посмотреть...",
                        avatar = R.drawable.ic_soccer,
                        date = "Yesterday"
                    )
                )
            } else if(index%3 == 0){
                add(
                    Groups(
                        name = "Сенбі 22:45 Шаляпина",
                        demoText = "04.02 Сенбі, Шаляпин к.",
                        avatar = R.drawable.ic_soccer,
                        date = "02.02.2023"
                    )
                )
            } else{
                add(
                    Groups(
                        name = "Android-2201",
                        demoText = "Ansar Задача: 1. Создать...",
                        avatar = R.drawable.ic_community,
                        date = "12:20"
                    )
                )
            }
        }
    }
}

@Parcelize
data class Groups(
    val name: String,
    val demoText: String,
    @DrawableRes val avatar: Int,
    val date: String
): Parcelable