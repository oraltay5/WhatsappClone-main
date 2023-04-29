package com.example.whatsappclone.authorization

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.whatsappclone.MainActivity
import com.example.whatsappclone.databinding.ActivityMainBinding
import com.example.whatsappclone.network.ApiServices
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModel<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {
            val username = binding.editUserName.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                viewModel.onViewCreated(username, password)
            } else {
                Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.success.observe(this@AuthActivity) { user ->
            startActivity(Intent(this@AuthActivity, MainActivity::class.java))
        }

//        viewModel.success.observe(this, Observer { user ->
//            startActivity(MainActivity.newIntent(this, user))
//        })
//
//        viewModel.error.observe(this, Observer { error ->
//            Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
//        })
    }
}


//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://dummyjson.com/")
////            .baseUrl("https://api.spaceflightnewsapi.net/")
////            .baseUrl("https://kitsu.io/api/edge/")
//            .addConverterFactory(GsonConverterFactory.create()).build()
//
//        val mainAPI = retrofit.create(ApiServices::class.java)
//
//        binding.btnSignIn.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                val users1 = mainAPI.auth(
//                    AuthDTO(
//                        binding.editUserName.text.toString(),
//                        binding.editPassword.text.toString()
//                    )
//                )
//                runOnUiThread{
//                    binding.apply {
//                        Picasso.get().load(users1.image).into(authView)
////                        textView.text = users1.firstName
////                        textView2.text = users1.lastName
//                    }
//                }
//            }
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//
//        }




//import android.annotation.SuppressLint
//import android.content.Intent
//import android.media.MediaPlayer
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.Menu
//import android.view.MenuItem
//import android.widget.Toast
//import androidx.annotation.DrawableRes
//import androidx.viewpager2.widget.ViewPager2
//import com.google.android.material.tabs.TabLayout
//import com.google.android.material.tabs.TabLayoutMediator
//import androidx.appcompat.widget.AppCompatImageView
//import androidx.core.content.ContextCompat
//import com.bumptech.glide.Glide
//import com.example.whatsappclone.R.drawable.ic_community
//import com.example.whatsappclone.menuActionBar.MusicActivity
//import com.example.whatsappclone.menuActionBar.SettingsActivity
//
///**
// *  Whatsapp clone
// *  1. Create XML design for main page
// *  2. Create fragments for each tab
// *  3. Create PagerAdapter
// *  4. Create XML for each fragment
// *  5. RecyclerView item
// */
//class AuthActivity : AppCompatActivity() {
//    //    private lateinit var mediaPlayer: MediaPlayer
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_auth)
//
////        mediaPlayer = MediaPlayer.create(this, R.raw.select)
////
////        val music = findViewById<AppCompatImageView>(R.id.searchIconView)
////        music.setOnClickListener {
////            mediaPlayer.start()
////        }
////
////        val moreActivity = findViewById<AppCompatImageView>(R.id.music)
////        moreActivity.setOnClickListener{
////            val intent = Intent(this, MusicActivity::class.java)
////            startActivity(intent)
////        }
//
//        setupView()
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.main_menu, menu)
//        return true
//    }
//
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.search -> {
//                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
//            }
//            R.id.music -> {
//                val music = Intent(this, MusicActivity::class.java)
//                startActivity(music)
//            }
//            R.id.group -> finish()
//            R.id.newsletter -> {
//                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
//            }
//            R.id.devices -> {
//                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
//            }
//            R.id.posts -> {
//                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
//            }
//            R.id.settings -> {
//                val setting = Intent(this, SettingsActivity::class.java)
//                startActivity(setting)
//            }
//        }
//        return false
//    }
//
//    private fun setupView() {
//        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
//        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
//
//        viewPager.adapter = PagerAdapter(lifecycle, supportFragmentManager)
//
//        TabLayoutMediator(
//            tabLayout,
//            viewPager,
//            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
//                when(position){
//                    0 -> tab.text = "Chats"
//                    1 -> tab.text = "Status"
//                    2 -> tab.text = "Calls"
//                    3 -> tab.text = "Groups"
//                    4 -> tab.text = "Music"
//                }
//            }
//        ).attach()
//    }
//}