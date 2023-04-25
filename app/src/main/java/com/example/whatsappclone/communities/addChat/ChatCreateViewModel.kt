package com.example.whatsappclone.communities.addChat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappclone.database.AppDatabase
import com.example.whatsappclone.database.entities.ChatEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatCreateViewModel(
    private val appDatabase: AppDatabase
): ViewModel() {

    private val _success = MutableLiveData<Unit>()
    val success: LiveData<Unit>
        get() = _success

    fun saveGroupInfo(name: String, desc: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                appDatabase.chatDao().addNewChatGroup(
                    ChatEntity(
                        name = name,
                        description = desc
                    )
                )
            }
            _success.value = Unit
        }
    }
}