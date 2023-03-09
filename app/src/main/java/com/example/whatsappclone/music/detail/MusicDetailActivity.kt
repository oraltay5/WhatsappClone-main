package com.example.whatsappclone.music.detail

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.example.whatsappclone.Chats
import com.example.whatsappclone.R
import com.example.whatsappclone.music.Music

class MusicDetailActivity : AppCompatActivity() {
    var music: Music? = null

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var seekBar: SeekBar
    private lateinit var runnable: Runnable
    private lateinit var handler: Handler
    var isPlayClicked = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_detail)
        music = intent.getParcelableExtra<Music>("ARG_MUSIC") as Music
        setupView()

        seekBar = findViewById(R.id.sbMusic)
        handler = Handler(Looper.getMainLooper())

//        seekBar.progress = 0
//        seekBar.max = mediaPlayer.duration
        mediaPlayer = MediaPlayer.create(this, R.raw.vibemusic)
        val playBtn = findViewById<ImageButton>(R.id.playBtn)
        playBtn.setOnClickListener {
        isPlayClicked = !isPlayClicked
        if(isPlayClicked){
            playBtn.setImageResource(R.drawable.ic_pause)
            mediaPlayer?.start()
            initSeekBar()
        }else{
            playBtn.setImageResource(R.drawable.ic_play)
            mediaPlayer?.pause()

        }
        }

        val favoriteBtnView = findViewById<ImageButton>(R.id.favoriteBtnView)
        favoriteBtnView.setOnClickListener {
            isPlayClicked = !isPlayClicked
            if(isPlayClicked){
                favoriteBtnView.setImageResource(R.drawable.ic_favorite2)
            }else{
                favoriteBtnView.setImageResource(R.drawable.ic_favorite1)
            }
        }

        val repeatIconView = findViewById<ImageButton>(R.id.repeatIconView)
        repeatIconView.setOnClickListener {
            isPlayClicked = !isPlayClicked
            if(isPlayClicked) {
                repeatIconView.setImageResource(R.drawable.ic_shuffle)
            }else{
                repeatIconView.setImageResource(R.drawable.ic_repeat)
            }
        }

        val backIcon = findViewById<AppCompatImageView>(R.id.backIconView)
        backIcon.setOnClickListener {
            finish()
        }
    }

    private fun setupView() {
        val nameView = findViewById<TextView>(R.id.nameMusicView)
        val labelView = findViewById<AppCompatImageView>(R.id.musicImageView)
        val ispTextView = findViewById<TextView>(R.id.ispTextView)
        val timeTextView = findViewById<TextView>(R.id.timeMusicView)

        ispTextView.text = "${music?.artistName}"
        nameView.text = "${music?.musicName}"
        timeTextView.text = "${music?.time}"
//        avatarView.drawable? = "${chat?.avatar}"
        Glide
            .with(labelView)
            .load("${music?.labelImage}")
            .centerCrop()
            .placeholder(R.drawable.ic_default)
            .into(labelView)
    }

    private fun initSeekBar(){
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(fromUser) mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

        })

        val startPlayed = findViewById<TextView>(R.id.startMusicText)
        val endPlayed = findViewById<TextView>(R.id.endMusicText)

        seekBar.max = mediaPlayer!!.duration
        runnable = Runnable {
            seekBar.progress = mediaPlayer!!.currentPosition

            val playedTime = mediaPlayer!!.currentPosition/1000
            startPlayed.text = "$playedTime sec"
            val duration = mediaPlayer!!.duration/1000
            val dueTime = duration-playedTime
            endPlayed.text = "$dueTime sec"

            handler.postDelayed(runnable, 1000)
        }
        handler.postDelayed(runnable, 1000)
    }
}