package com.example.whatsappclone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whatsappclone.database.entities.ChatEntity


@Database(
    version = 1,
    entities = [
        ChatEntity::class,
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun chatDao() : ChatDao

    companion object {
        private val LOCK = Any()

        @Volatile
        private var sInstance: AppDatabase? = null
        private const val DATABASE_NAME = "whatsapp_db"

        fun getInstance(context: Context): AppDatabase? {
            if (sInstance == null) {
                synchronized(LOCK) {
                    if (sInstance == null) {
                        sInstance = Room.databaseBuilder(
                            context, AppDatabase::class.java, DATABASE_NAME
                        ).build()
                    }
                }
            }
            return sInstance
        }
    }
}