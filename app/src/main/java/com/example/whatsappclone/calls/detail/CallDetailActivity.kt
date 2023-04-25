package com.example.whatsappclone.calls.detail

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Button
import android.telecom.Call
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.example.whatsappclone.Calls
import com.example.whatsappclone.R
import com.example.whatsappclone.broadcastReceivers.BroadcastConstants.DYNAMIC_BROADCAST
import com.example.whatsappclone.broadcastReceivers.BroadcastConstants.STATIC_BROADCAST
import com.example.whatsappclone.broadcastReceivers.DynamicBroadcastReceiver
import com.example.whatsappclone.broadcastReceivers.StaticBroadcastReceiver

class CallDetailActivity : AppCompatActivity() {
    var call: Calls? = null
    var name: String? = null
    var groupName: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_detail)

        val backIcon = findViewById<AppCompatImageView>(R.id.closeIconView)
        backIcon.setOnClickListener {
            finish()
        }

        if(intent.extras!!.containsKey("ARG_FROM_CHAT")){
            name = intent.getStringExtra("ARG_FROM_CHAT")
        }else if(intent.extras!!.containsKey("ARG_FROM_GROUP")){
            groupName = intent.getStringExtra("ARG_FROM_GROUP")
        }else if(intent.extras!!.containsKey("ARG_CALL")){
            call = intent.getParcelableExtra<Calls>("ARG_CALL") as Calls
        }

        setupView()
    }
    private fun setupView() {
        val textView = findViewById<TextView>(R.id.textView2)

        if (call != null){
            textView.text = "${call?.name}"
        }else if(name!= null){
            textView.text = "${name}"
        }else if(groupName!= null){
            textView.text = "${groupName}"
        }
    }
}