package com.example.whatsappclone.di

import com.example.whatsappclone.network.createApplicationService
import org.koin.dsl.module

val networkModule = module{
    single { createApplicationService("https://dummyjson.com/") }
}