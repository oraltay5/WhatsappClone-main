package com.example.whatsappclone.communities

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.chats.detail.ChatDetailActivity
import com.example.whatsappclone.communities.ChatViewModel
import com.example.whatsappclone.communities.ComRecyclerAdapter
import com.example.whatsappclone.communities.addChat.ChatCreateActivity
import com.example.whatsappclone.communities.detail.BroadcastActivity
import com.example.whatsappclone.communities.detail.ComDetailActivity
import com.example.whatsappclone.database.AppDatabase
import com.example.whatsappclone.database.entities.ChatEntity
import com.example.whatsappclone.sampleNavigation.NavigationActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.parcelize.Parcelize
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommunitiesFragment: Fragment(R.layout.fragment_commun) {

    private val viewModel by viewModel<ChatViewModel>()
    lateinit var recyclerView: RecyclerView
    lateinit var appDatabase: AppDatabase


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()
        setupView(view)
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.onViewCreated()
    }

    private fun setupView(view: View) {
        recyclerView = view.findViewById(R.id.comRecyclerView)

        view.findViewById<LinearLayout>(R.id.newGroup).setOnClickListener {
            startActivity(Intent(activity, ChatCreateActivity::class.java))
        }

        view.findViewById<LinearLayout>(R.id.newContact).setOnClickListener {
            startActivity(Intent(activity, NavigationActivity::class.java))
        }

        view.findViewById<LinearLayout>(R.id.checkBrod).setOnClickListener {
            startActivity(Intent(activity, BroadcastActivity::class.java))
        }

        recyclerView = view.findViewById<RecyclerView>(R.id.comRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeViewModel() = with(viewModel){
        callsData.observe(viewLifecycleOwner) { groupList ->
            recyclerView.adapter = ComRecyclerAdapter(
                item = groupList,
                onItemClickListener = { chat ->
                    deleteChat(chat.id)
                }
            )
        }
    }

    suspend fun deleteChat(id: Long) {
        withContext(Dispatchers.IO) { //Функция withContext() - чтобы запрос на удаление выполняется в фоновом потоке
            appDatabase.chatDao().deleteChatById(id)
        }
    }
}

//Мы использовали ключевое слово suspend для функции deleteChat(), потому что она взаимодействует с базой данных, что может занять длительное время.
//Функции, которые могут занять длительное время, не должны блокировать основной поток пользовательского интерфейса. Вместо этого мы помечаем такие функции ключевым словом suspend, чтобы их можно было вызывать из корутина. Корутины позволяют выполнять асинхронные операции без блокировки основного потока и приостановки работы приложения.




















//-----------------------------------------------------------------------------------------------------------
//import android.content.Intent
//import android.os.Bundle
//import android.os.Parcelable
//import android.view.View
//import android.widget.LinearLayout
//import androidx.annotation.DrawableRes
//import androidx.appcompat.widget.AppCompatImageView
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.whatsappclone.chats.detail.ChatDetailActivity
//import com.example.whatsappclone.communities.ComRecyclerAdapter
//import com.example.whatsappclone.communities.detail.BroadcastActivity
//import com.example.whatsappclone.communities.detail.ComDetailActivity
//import com.example.whatsappclone.sampleNavigation.NavigationActivity
//import kotlinx.coroutines.channels.BroadcastChannel
//import kotlinx.parcelize.Parcelize
//
//class CommunitiesFragment: Fragment(R.layout.fragment_commun) {
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val aaa = view.findViewById<LinearLayout>(R.id.newGroup)
//        aaa.setOnClickListener{
//            val intent = Intent(activity, NavigationActivity::class.java)
//            startActivity(intent)
//        }
//
//        val bbb = view.findViewById<LinearLayout>(R.id.newContact)
//        bbb.setOnClickListener{
//            val intent = Intent(activity, NavigationActivity::class.java)
//            startActivity(intent)
//        }
//
//        val ccc = view.findViewById<LinearLayout>(R.id.checkBrod)
//        ccc.setOnClickListener{
//            val intent = Intent(activity, BroadcastActivity::class.java)
//            startActivity(intent)
//        }
//
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        recyclerView.adapter = ComRecyclerAdapter(
//            item = getComSampleData(),
//            onItemClickListener = { group ->
//                val intent = Intent(activity, ComDetailActivity::class.java)
//                intent.putExtra("ARG_GROUP", group)
//                startActivity(intent)
//            }
//        )
//    }
//
//    private fun getComSampleData() = mutableListOf<Groups>().apply {
//        (1..3).forEach {index ->
//            if(index%2 == 0) {
//                add(
//                    Groups(
//                        name = "Футбол сарапшылары",
//                        demoText = "здесь можете посмотреть...",
//                        avatar = R.drawable.ic_soccer,
//                        date = "Yesterday"
//                    )
//                )
//            } else if(index%3 == 0){
//                add(
//                    Groups(
//                        name = "Сенбі 22:45 Шаляпина",
//                        demoText = "04.02 Сенбі, Шаляпин к.",
//                        avatar = R.drawable.ic_soccer,
//                        date = "02.02.2023"
//                    )
//                )
//            } else{
//                add(
//                    Groups(
//                        name = "Android-2201",
//                        demoText = "Ansar Задача: 1. Создать...",
//                        avatar = R.drawable.ic_community,
//                        date = "12:20"
//                    )
//                )
//            }
//        }
//    }
//}
//
//@Parcelize
//data class Groups(
//    val name: String,
//    val demoText: String,
//    @DrawableRes val avatar: Int,
//    val date: String
//): Parcelable