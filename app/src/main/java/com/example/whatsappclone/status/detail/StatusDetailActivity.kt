package com.example.whatsappclone.status.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.example.whatsappclone.R

class StatusDetailActivity : AppCompatActivity() {
    var name: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status_detail)

        name = intent.getStringExtra("ARG_NAME")
        setupView()

        val backIcon = findViewById<AppCompatImageView>(R.id.backIconView)
        backIcon.setOnClickListener {
            finish()
        }


    }

    private fun setupView() {
        val textView = findViewById<TextView>(R.id.nameStatsTextView)

        textView.text = "$name"
    }
}