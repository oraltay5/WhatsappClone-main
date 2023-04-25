package com.example.whatsappclone.communities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappclone.database.AppDatabase
import com.example.whatsappclone.database.entities.ChatEntity
import kotlinx.coroutines.*

class ChatViewModel(
    private val appDatabase: AppDatabase
): ViewModel() {

    private val _callsData = MutableLiveData<List<ChatEntity>>()
    val callsData: LiveData<List<ChatEntity>>
        get() = _callsData


    fun onViewCreated(){
        viewModelScope.launch {
            val chats = withContext(Dispatchers.IO){
                appDatabase.chatDao().getAllChats()
            }
            _callsData.value = chats
        }
    }
}



//package com.example.whatsappclone.communities
//
//import androidx.lifecycle.*
//import com.example.whatsappclone.database.AppDatabase
//import com.example.whatsappclone.database.entities.ChatEntity
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//class ChatViewModel(
//    private val appDatabase: AppDatabase
//): ViewModel() {
//
//    private val chatsLiveData = MediatorLiveData<List<ChatEntity>>()
//
//    init {
//        loadChats()
//    }
//
//    private fun loadChats() {
//        chatsLiveData.addSource(appDatabase.chatDao().getAllChatsLiveData()) { chats ->
//            chatsLiveData.value = chats
//        }
//    }
//
//    fun refreshChats() {
//        viewModelScope.launch {
//            withContext(Dispatchers.IO) {
//                appDatabase.chatDao().refreshChats()
//            }
//        }
//    }
//
//    fun getChatsLiveData(): LiveData<List<ChatEntity>> {
//        return chatsLiveData
//    }
//}
