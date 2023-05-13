package com.example.whatsappclone.communities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappclone.database.AppDatabase
import com.example.whatsappclone.database.entities.ChatEntity
import kotlinx.coroutines.*

class ComViewModel(
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

    fun deleteChat(id: Long) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {   //Функция withContext() - чтобы запрос на удаление выполняется в фоновом потоке
                appDatabase.chatDao().deleteChatById(id)
            }
            // Refresh callsData after deleting chat
            onViewCreated()
        }
    }
//Мы использовали ключевое слово suspend для функции deleteChat(), потому что она взаимодействует с базой данных, что может занять длительное время.
//Функции, которые могут занять длительное время, не должны блокировать основной поток пользовательского интерфейса. Вместо этого мы помечаем такие функции ключевым словом suspend, чтобы их можно было вызывать из корутина. Корутины позволяют выполнять асинхронные операции без блокировки основного потока и приостановки работы приложения.
///
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
