package com.example.whatsappclone

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import android.view.View
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.calls.CallsRecyclerAdapter
import com.example.whatsappclone.calls.detail.CallDetailActivity
import com.example.whatsappclone.status.detail.StatusDetailActivity

class CallsFragment: Fragment(R.layout.fragment_calls) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = CallsRecyclerAdapter(
            item = getCallsSampleData(),
            onItemClickListener = { call ->
                val intent = Intent(activity, CallDetailActivity::class.java)
                intent.putExtra("ARG_CALL", call)
                startActivity(intent)
            }
        )
    }

    private fun getCallsSampleData() = mutableListOf<Calls>().apply {
        (1..4).forEach {index ->
            if(index == 2) {
                add(
                    Calls(
                        name = "Ansar ($index)",
                        demoText = "Missed call",
                        avatar = R.drawable.ic_callmiss,
                        date = "Yesterday"
                    )
                )
            } else if(index > 2){
                add(
                    Calls(
                        name = "Temir",
                        demoText = "Calling",
                        avatar = R.drawable.ic_call,
                        date = "02.02.2023"
                    )
                )
            } else{
                add(
                    Calls(
                        name = "Kaira",
                        demoText = "Calling",
                        avatar = R.drawable.ic_call,
                        date = "12:20"
                    )
                )
            }
        }
    }
}

@Parcelize

data class Calls(
    val name: String,
    val demoText: String,
    @DrawableRes val avatar: Int,
    val date: String
): Parcelable


