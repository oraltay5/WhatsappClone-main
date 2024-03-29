package com.example.whatsappclone.chats

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsappclone.R
import com.example.whatsappclone.chats.detail.ChatDetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatsFragment: Fragment(R.layout.fragment_chats) {

    private val viewModel by viewModel<ChatsViewModel>()

    lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
        observeViewModel()
        viewModel.onViewCreated()
    }

    private fun setupView(view: View){
        recyclerView = view.findViewById<RecyclerView>(R.id.chatRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun observeViewModel(){
        viewModel.basketDetailData.observe(viewLifecycleOwner){ animeList ->
            recyclerView.adapter = ChatRecyclerAdapter(
                item = animeList,
                onItemClickListener = { chat ->
                    val intent = Intent(activity, ChatDetailActivity::class.java)
                    intent.putExtra("ARG_CHAT", chat)
                    startActivity(intent)
                }
            )
        }
    }
}





//package com.example.whatsappclone
//
//import android.content.Intent
//import android.os.Bundle
//import android.view.View
//import android.os.Parcelable
//import kotlinx.parcelize.Parcelize
//import androidx.annotation.DrawableRes
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.whatsappclone.chats.ChatRecyclerAdapter
//import com.example.whatsappclone.chats.detail.ChatDetailActivity
//import com.example.whatsappclone.chats.model.Chats
//import com.example.whatsappclone.network.AnimeDTO
//import com.example.whatsappclone.network.AnimeListDTO
////import com.example.whatsappclone.network.AnimeListDTO
//import com.example.whatsappclone.network.ApiClient
//import com.example.whatsappclone.network.ApiServices
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//
//class ChatsFragment: Fragment(R.layout.fragment_chats) {
////
////    lateinit var apiServices: ApiServices
////
////    lateinit var recyclerView: RecyclerView
////    private val animeList = mutableListOf<Chats>()
////
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////        setupView(view)
////        getAnimeList()
////    }
////
////    private fun setupView(view: View){
////        recyclerView = view.findViewById<RecyclerView>(R.id.chatRecyclerView)
////        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
////    }
////
////    private fun getAnimeList(){
////        apiServices = ApiClient().getClient()?.create(ApiServices::class.java)!!
////
////        val animeListCall = apiServices.getAnimeList()
////
////        animeListCall.enqueue(object : Callback<AnimeListDTO> {
////            override fun onResponse(call: Call<AnimeListDTO>, response: Response<AnimeListDTO>) {
////                val responseSuccess = response.body()
////
////                responseSuccess?.let {animeDTO ->
////                    animeDTO.data.forEach {
////                        animeList.add(
////                            Chats(
////                                name = it.attributes.slug,
////                                demoText = it.attributes.description,
////                                avatar = it.attributes.posterImage.original,
////                                date = it.attributes.averageRating
////                            )
////                        )
////                    }
////                }
////
////                recyclerView.adapter = ChatRecyclerAdapter(
////                    item = animeList,
////                    onItemClickListener = { chat ->
////                        val intent = Intent(activity, ChatDetailActivity::class.java)
////                        intent.putExtra("ARG_CHAT", chat)
////                        startActivity(intent)
////                    }
////                )
////            }
////
////            override fun onFailure(call: Call<AnimeListDTO>, t: Throwable) {
//////                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
////            }
////        })
////    }
//
//    //-----------------------------------------------------------------------------------------------------------------
//
////    lateinit var apiServices: ApiServices
////
////    lateinit var recyclerView: RecyclerView
////    private val animeList = mutableListOf<Chats>()
////
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////        super.onViewCreated(view, savedInstanceState)
////        setupView(view)
////        getAnimeList()
////    }
////
////    private fun setupView(view: View){
////        recyclerView = view.findViewById<RecyclerView>(R.id.chatRecyclerView)
////        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
////    }
////
////    private fun getAnimeList(){
////        apiServices = ApiClient().getClient()?.create(ApiServices::class.java)!!
////
////        val animeListCall = apiServices.getAnimeList()
////
////        animeListCall.enqueue(object : Callback<AnimeListDTO> {
////            override fun onResponse(call: Call<AnimeListDTO>, response: Response<AnimeListDTO>) {
////                val responseSuccess = response.body()
////
////                responseSuccess?.let {animeDTO ->
////                    animeDTO.articles.forEach {
////                        animeList.add(
////                            Chats(
////                                name = it.newsSite,
////                                demoText = it.title,
////                                avatar = it.imageUrl,
////                                date = it.updatedAt
////                            )
////                        )
////                    }
////                }
////
////                recyclerView.adapter = ChatRecyclerAdapter(
////                    item = animeList,
////                    onItemClickListener = { chat ->
////                        val intent = Intent(activity, ChatDetailActivity::class.java)
////                        intent.putExtra("ARG_CHAT", chat)
////                        startActivity(intent)
////                    }
////                )
////            }
////
////            override fun onFailure(call: Call<AnimeListDTO>, t: Throwable) {
//////                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
////            }
////        })
////    }
//
//    //--------------------------------------------------------------------------------------------------------------------------
//
//    private lateinit var apiServices: ApiServices
//
//    lateinit var recyclerView: RecyclerView
//    private val animeList = mutableListOf<Chats>()
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        setupView(view)
//        getAnimeList()
//    }
//
//    private fun setupView(view: View){
//        recyclerView = view.findViewById<RecyclerView>(R.id.chatRecyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//    }
//
//    private fun getAnimeList(){
//        apiServices = ApiClient().getClient()?.create(ApiServices::class.java)!!
//
//        val animeListCall = apiServices.getAnimeList()
//
//        animeListCall.enqueue(object : Callback<AnimeListDTO> {
//            override fun onResponse(call: Call<AnimeListDTO>, response: Response<AnimeListDTO>) {
//                val responseSuccess = response.body()
//
//                responseSuccess?.let {animeDTO ->
//                    animeDTO.users.forEach{
//                        animeList.add(
//                            Chats(
//                                firstName = it.firstName,
//                                lastName = it.lastName,
//                                demoText = it.address.address,
//                                avatar = it.image,
//                                date = it.birthDate
//                            )
//                        )
//                    }
//                }
//
//                recyclerView.adapter = ChatRecyclerAdapter(
//                    item = animeList,
//                    onItemClickListener = { chat ->
//                        val intent = Intent(activity, ChatDetailActivity::class.java)
//                        intent.putExtra("ARG_CHAT", chat)
//                        startActivity(intent)
//                    }
//                )
//            }
//
//            override fun onFailure(call: Call<AnimeListDTO>, t: Throwable) {
//                //                Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
//            }
//        })
//    }
//
////    private fun getChatSampleData() = mutableListOf<Chats>().apply {
////        (1..20).forEach {index ->
////            if(index == 2) {
////                add(
////                    Chats(
////                        firstName = "$index Bill Gates",
////                        lastName = "Gates",
////                        demoText = "Good job!!!",
//////                        avatar = R.drawable.bill_gates,
////                        avatar = "https://pbs.twimg.com/profile_images/1564398871996174336/M-hffw5a_400x400.jpg",
////                        date = "Yesterday"
////                    )
////                )
////            } else if(index > 2){
////                add(
////                    Chats(
////                        firstName = "$index Steve Jobs",
////                        lastName = "Gates",
////                        demoText = "Hello developers!!!",
//////                        avatar = R.drawable.bill_gates,
////                        avatar = "https://cdn.britannica.com/04/171104-050-AEFE3141/Steve-Jobs-iPhone-2010.jpg",
////                        date = "01.02.2023"
////                    )
////                )
////            } else{
////                add(
////                    Chats(
////                        firstName = "$index Bill Gates",
////                        lastName = "Gates",
////                        demoText = "Hi!!!",
//////                        avatar = R.drawable.bill_gates,
////                        avatar = "https://pbs.twimg.com/profile_images/1564398871996174336/M-hffw5a_400x400.jpg",
////                        date = "12:20"
////                    )
////                )
////            }
////        }
////    }
//}
//
//@Parcelize
//data class Chats(
//    val firstName: String,
//    val lastName: String,
//    val demoText: String,
//    val avatar: String,
////    @DrawableRes val avatar: Int,
//    val date: String
//): Parcelable
