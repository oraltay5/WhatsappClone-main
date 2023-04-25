package com.example.whatsappclone

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.whatsappclone.R.drawable.ic_community
import com.example.whatsappclone.menuActionBar.MusicActivity
import com.example.whatsappclone.menuActionBar.SettingsActivity

/**
 *  Whatsapp clone
 *  1. Create XML design for main page
 *  2. Create fragments for each tab
 *  3. Create PagerAdapter
 *  4. Create XML for each fragment
 *  5. RecyclerView item
 */
class MainActivity : AppCompatActivity() {
//    private lateinit var mediaPlayer: MediaPlayer
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

//        mediaPlayer = MediaPlayer.create(this, R.raw.select)
//
//        val music = findViewById<AppCompatImageView>(R.id.searchIconView)
//        music.setOnClickListener {
//            mediaPlayer.start()
//        }
//
//        val moreActivity = findViewById<AppCompatImageView>(R.id.music)
//        moreActivity.setOnClickListener{
//            val intent = Intent(this, MusicActivity::class.java)
//            startActivity(intent)
//        }

        setupView()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.music -> {
                val music = Intent(this, MusicActivity::class.java)
                startActivity(music)
            }
            R.id.group -> finish()
            R.id.newsletter -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.devices -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.posts -> {
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.settings -> {
                val setting = Intent(this, SettingsActivity::class.java)
                startActivity(setting)
            }
        }
        return true
    }

    private fun setupView() {
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)

        viewPager.adapter = PagerAdapter(lifecycle, supportFragmentManager)

        TabLayoutMediator(
            tabLayout,
            viewPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when(position){
                    0 -> tab.text = "Chats"
                    1 -> tab.text = "Status"
                    2 -> tab.text = "Calls"
                    3 -> tab.text = "Groups"
                    4 -> tab.text = "Music"
                }
            }
        ).attach()
    }
}


//import android.annotation.SuppressLint
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.example.whatsappclone.databinding.ActivityMainBinding
//
//class MainActivity : AppCompatActivity() {
//    lateinit var binding: ActivityMainBinding
//    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//    }
//}