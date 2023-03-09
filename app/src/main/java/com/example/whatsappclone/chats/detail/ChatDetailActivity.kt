package com.example.whatsappclone.chats.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.whatsappclone.Chats
import com.example.whatsappclone.R
import com.example.whatsappclone.calls.detail.CallDetailActivity

class ChatDetailActivity: AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    var chat: Chats? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_detail)

        chat = intent.getParcelableExtra<Chats>("ARG_CHAT") as Chats

        mediaPlayer = MediaPlayer.create(this, R.raw.select)
        setupView()

        val music = findViewById<AppCompatImageView>(R.id.voiceIconView)
        music.setOnClickListener {
            mediaPlayer.start()
        }

        val call = findViewById<AppCompatImageView>(R.id.chatCallIconView)
        call.setOnClickListener {
            val intent = Intent(this, CallDetailActivity::class.java)
            intent.putExtra("ARG_FROM_CHAT", chat?.name)
            startActivity(intent)
        }



        val allChatView = findViewById<RelativeLayout>(R.id.allChatView)
        allChatView.setBackgroundResource(R.drawable.bbackgroundd)

        val voiceChatIcon = findViewById<RelativeLayout>(R.id.voiceChatIcon)
        val messageView = findViewById<RelativeLayout>(R.id.messageView)
        val chatRelAvatarView = findViewById<RelativeLayout>(R.id.chatRelAvatarView)
        voiceChatIcon.setBackgroundResource(R.drawable.krugliye_ugli)
        messageView.setBackgroundResource(R.drawable.shape_relative)
        chatRelAvatarView.setBackgroundResource(R.drawable.shape_relative)

        val backIcon = findViewById<AppCompatImageView>(R.id.backIconView)
        backIcon.setOnClickListener {
            finish()
        }

    }

    private fun setupView() {
        val textView = findViewById<TextView>(R.id.nameTextView)
        val avatarView = findViewById<AppCompatImageView>(R.id.chatAvatarView)
        val chatTextView = findViewById<TextView>(R.id.chatMTextView)
        val chatDateTextView = findViewById<TextView>(R.id.chatDateTextView)

        chatTextView.text = "${chat?.demoText}"
        textView.text = "${chat?.name}"
        chatDateTextView.text = "${chat?.date}"
//        avatarView.drawable? = "${chat?.avatar}"
        Glide
            .with(avatarView)
            .load("${chat?.avatar}")
            .centerCrop()
            .placeholder(R.drawable.ic_default)
            .into(avatarView)
    }
}