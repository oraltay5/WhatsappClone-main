package com.example.whatsappclone.di

import com.example.whatsappclone.authorization.AuthViewModel
import com.example.whatsappclone.chats.ChatsViewModel
import com.example.whatsappclone.communities.ComViewModel
import com.example.whatsappclone.communities.addChat.ChatCreateViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ChatsViewModel(get()) }
    viewModel { AuthViewModel(get()) }
    viewModel { ComViewModel(get()) }
    viewModel { ChatCreateViewModel(get()) }
}