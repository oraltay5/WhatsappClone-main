package com.example.whatsappclone.communities.detail

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.whatsappclone.R
import com.example.whatsappclone.broadcastReceivers.BroadcastConstants
import com.example.whatsappclone.broadcastReceivers.DynamicBroadcastReceiver

class BroadcastActivity : AppCompatActivity() {
    private val dynamicBroadcastReceiver = DynamicBroadcastReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)
        setupView()
        registerDynamicBroadCast()
//        registerStaticBroadCast()
    }

    private fun registerDynamicBroadCast() {
        val filter = IntentFilter(BroadcastConstants.DYNAMIC_BROADCAST)
        this.registerReceiver(dynamicBroadcastReceiver, filter)
    }
//    private fun registerStaticBroadCast() {
//        val filter = IntentFilter(STATIC_BROADCAST)
//        this.registerReceiver(staticBroadcastReceiver, filter)
//    }

    private fun setupView() {
        val dynamicButton = findViewById<Button>(R.id.button2)
        val staticButton = findViewById<Button>(R.id.button3)

        dynamicButton.setOnClickListener {
            val intent = Intent()
            intent.action = BroadcastConstants.DYNAMIC_BROADCAST
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES)
            sendBroadcast(intent)
        }

        staticButton.setOnClickListener {
            val intent = Intent()
            intent.action = BroadcastConstants.STATIC_BROADCAST
            sendBroadcast(intent)
        }
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(dynamicBroadcastReceiver)
//        unregisterReceiver(staticBroadcastReceiver)
    }
}