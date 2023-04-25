package com.example.whatsappclone.status

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.authorization.AuthActivity
import com.example.whatsappclone.R

class StatusFragment: Fragment(R.layout.fragment_status) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewStatus)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = StatusRecyclerAdapter(
            item = getStatusSampleData(),
            onItemClickListener = { name ->
                val intent = Intent(activity, AuthActivity::class.java)
                intent.putExtra("ARG_NAME", name)
                startActivity(intent)
            }
        )


    }


    private fun getStatusSampleData() = mutableListOf<Status>().apply {
        (1..6).forEach {index ->
//            add("Status $index")
            if(index < 20) {
                add(
                    Status(
                        name = "Status $index",
                        demoText = "Unwatched",
                        avatar = R.drawable.ic_default,
//                        avatarUrl = "https://pbs.twimg.com/profile_images/1564398871996174336/M-hffw5a_400x400.jpg",
                        date = "3 hours ago"
                    )
                )
            }
        }
    }
}

data class Status(
    val name: String,
    val demoText: String,
//    val avatarUrl: String,
    @DrawableRes val avatar: Int,
    val date: String
)
