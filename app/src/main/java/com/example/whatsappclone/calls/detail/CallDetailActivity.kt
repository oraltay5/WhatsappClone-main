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
    private val dynamicBroadcastReceiver = DynamicBroadcastReceiver()
//    private val staticBroadcastReceiver = StaticBroadcastReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call_detail)

        if(intent.extras!!.containsKey("ARG_FROM_CHAT")){
            name = intent.getStringExtra("ARG_FROM_CHAT")
        }else if(intent.extras!!.containsKey("ARG_FROM_GROUP")){
            groupName = intent.getStringExtra("ARG_FROM_GROUP")
        }else if(intent.extras!!.containsKey("ARG_CALL")){
            call = intent.getParcelableExtra<Calls>("ARG_CALL") as Calls
        }



        setupView()

        val backIcon = findViewById<AppCompatImageView>(R.id.closeIconView)
        backIcon.setOnClickListener {
            finish()
        }
        registerDynamicBroadCast()
//        registerStaticBroadCast()
    }

    private fun registerDynamicBroadCast() {
        val filter = IntentFilter(DYNAMIC_BROADCAST)
        this.registerReceiver(dynamicBroadcastReceiver, filter)
    }
//    private fun registerStaticBroadCast() {
//        val filter = IntentFilter(STATIC_BROADCAST)
//        this.registerReceiver(staticBroadcastReceiver, filter)
//    }


    private fun setupView() {
        val textView = findViewById<TextView>(R.id.textView2)
        val dynamicButton = findViewById<Button>(R.id.dynamicButton)
        val staticButton = findViewById<Button>(R.id.staticButton)


        if (call != null){
            textView.text = "${call?.name}"
        }else if(name!= null){
            textView.text = "${name}"
        }else if(groupName!= null){
            textView.text = "${groupName}"
        }

        dynamicButton.setOnClickListener {
            val intent = Intent()
            intent.action = DYNAMIC_BROADCAST
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            sendBroadcast(intent)
        }

        staticButton.setOnClickListener {
            val intent = Intent()
            intent.action = STATIC_BROADCAST
            sendBroadcast(intent)
        }
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(dynamicBroadcastReceiver)
//        unregisterReceiver(staticBroadcastReceiver)
    }
}