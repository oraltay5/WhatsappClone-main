package com.example.whatsappclone.di

import com.example.whatsappclone.database.AppDatabase
import com.example.whatsappclone.database.ChatDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single { AppDatabase.getInstance(androidContext()) }
    single { provideChatDao(get()) }

}

fun provideChatDao(appDatabase: AppDatabase): ChatDao {
    return appDatabase.chatDao()
}