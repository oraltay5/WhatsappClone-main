package com.example.whatsappclone.authorization

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.whatsappclone.MainActivity
import com.example.whatsappclone.chats.model.Chats
import com.example.whatsappclone.databinding.ActivityMainBinding
import com.example.whatsappclone.network.AnimeListDTO
import com.example.whatsappclone.network.ApiServices
import com.example.whatsappclone.network.AuthDTO
import com.example.whatsappclone.network.UsersDTO
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthViewModel(
    private val apiServices: ApiServices,
    ): ViewModel()  {

    private val _success = MutableLiveData<UsersDTO>()
    val success: LiveData<UsersDTO>
        get() = _success

    fun onViewCreated(name:String, password:String){

            CoroutineScope(Dispatchers.IO).launch {
                val users1 = apiServices.auth(
                    AuthDTO(
                        name,
                        password
                    )
                )
                _success.value = users1

            }
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)



//        apiServices.auth().enqueue(object : Callback<UsersDTO> {
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
//                    _basketDetailData.value = animeList
//                }
//            }
//
//            override fun onFailure(call: Call<AnimeListDTO>, t: Throwable) {
//                //Toast.makeText(this@MainActivity, "ERROR", Toast.LENGTH_SHORT).show()
//            }
//        })
    }
}