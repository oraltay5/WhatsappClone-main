package com.example.whatsappclone.di

import com.example.whatsappclone.authorization.AuthViewModel
import com.example.whatsappclone.chats.ChatViewModel
import com.example.whatsappclone.communities.addChat.ChatCreateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ChatViewModel(get()) }
    viewModel { AuthViewModel(get()) }
//    factory { ChatViewModel(get()) }
    viewModel { ChatCreateViewModel(get()) }
}