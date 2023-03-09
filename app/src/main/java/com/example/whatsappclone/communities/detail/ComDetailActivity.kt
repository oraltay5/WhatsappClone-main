package com.example.whatsappclone.communities.detail

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsappclone.Chats
import com.example.whatsappclone.Groups
import com.example.whatsappclone.R
import com.example.whatsappclone.calls.detail.CallDetailActivity

class ComDetailActivity: AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    var group: Groups? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_com_detail)

        group = intent.getParcelableExtra<Groups>("ARG_GROUP") as Groups

        mediaPlayer = MediaPlayer.create(this, R.raw.select)
        setupView()

        val music = findViewById<AppCompatImageView>(R.id.voiceIconView)
        music.setOnClickListener {
            mediaPlayer.start()
        }

        val call = findViewById<AppCompatImageView>(R.id.comCallIconView)
        call.setOnClickListener {
            val intent = Intent(this, CallDetailActivity::class.java)
            intent.putExtra("ARG_FROM_GROUP", group?.name)
            startActivity(intent)
        }

//        val v = findViewById<RelativeLayout>(R.id.voiceChatIcon)
        val b = findViewById<RelativeLayout>(R.id.messageView)
        val n = findViewById<RelativeLayout>(R.id.voiceChatIcon)
        val relativeLayout = findViewById<RelativeLayout>(R.id.msgComView)
//        v.setBackgroundResource(R.drawable.shape_image)
        b.setBackgroundResource(R.drawable.shape_relative)
        n.setBackgroundResource(R.drawable.krugliye_ugli)
        relativeLayout.setBackgroundResource(R.drawable.bbackgroundd)

        val backIcon = findViewById<AppCompatImageView>(R.id.backIconView)
        backIcon.setOnClickListener {
            finish()
        }

        setupView()
    }

    private fun setupView() {
        val textView = findViewById<TextView>(R.id.nameComTextView)
        val avatarView = findViewById<AppCompatImageView>(R.id.comAvatarView)
        val dateTextView = findViewById<TextView>(R.id.comDateTextView)
        val chatTextView = findViewById<TextView>(R.id.comMTextView)


        chatTextView.text = "${group?.demoText}"
        textView.text = "${group?.name}"
        dateTextView.text = "${group?.date}"
//        avatarView.drawable = "$avatar"
        Glide
            .with(avatarView)
            .load("${group?.avatar}")
            .centerCrop()
            .placeholder(R.drawable.ic_default)
            .into(avatarView)
    }
}