package com.example.whatsappclone.chats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatsappclone.chats.model.Chats
import com.example.whatsappclone.network.AnimeListDTO
import com.example.whatsappclone.network.ApiServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ChatsViewModel(
    private val apiServices: ApiServices
): ViewModel() {

    private val _basketDetailData = MutableLiveData<List<Chats>>()
    val basketDetailData: LiveData<List<Chats>>
        get() = _basketDetailData

    private val animeList = mutableListOf<Chats>()

    fun onViewCreated(){
        apiServices.getAnimeList().enqueue(object : Callback<AnimeListDTO> {
            override fun onResponse(call: Call<AnimeListDTO>, response: Response<AnimeListDTO>) {
                val responseSuccess = response.body()

                responseSuccess?.let {animeDTO ->
                    animeDTO.users.forEach{
                        animeList.add(
                            Chats(
                                firstName = it.firstName,
                                lastName = it.lastName,
                                demoText = it.address.address,
                                avatar = it.image,
                                date = it.birthDate
                            )
                        )
                    }
                    _basketDetailData.value = animeList
                }
            }

            override fun onFailure(call: Call<AnimeListDTO>, t: Throwable) {
                //Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }
        })
    }

//    fun getChatSampleData() = mutableListOf<Chats>().apply {
//        (1..20).forEach {index ->
//            if(index == 2) {
//                add(
//                    Chats(
//                        firstName = "$index Bill Gates",
//                        lastName = "Gates",
//                        demoText = "Good job!!!",
////                        avatar = R.drawable.bill_gates,
//                        avatar = "https://pbs.twimg.com/profile_images/1564398871996174336/M-hffw5a_400x400.jpg",
//                        date = "Yesterday"
//                    )
//                )
//            } else if(index > 2){
//                add(
//                    Chats(
//                        firstName = "$index Steve Jobs",
//                        lastName = "Gates",
//                        demoText = "Hello developers!!!",
////                        avatar = R.drawable.bill_gates,
//                        avatar = "https://cdn.britannica.com/04/171104-050-AEFE3141/Steve-Jobs-iPhone-2010.jpg",
//                        date = "01.02.2023"
//                    )
//                )
//            } else{
//                add(
//                    Chats(
//                        firstName = "$index Bill Gates",
//                        lastName = "Gates",
//                        demoText = "Hi!!!",
////                        avatar = R.drawable.bill_gates,
//                        avatar = "https://pbs.twimg.com/profile_images/1564398871996174336/M-hffw5a_400x400.jpg",
//                        date = "12:20"
//                    )
//                )
//            }
//        }
//    }

}

