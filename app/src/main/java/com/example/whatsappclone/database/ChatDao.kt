package com.example.whatsappclone.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.whatsappclone.database.entities.ChatEntity
import retrofit2.http.DELETE

@Dao
interface ChatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewChatGroup(chat: ChatEntity)

    @Query("SELECT * FROM groups")
    fun getAllChats(): List<ChatEntity>

    @Query("SELECT * FROM groups WHERE id = :id")
    fun getGroupById(id: Long): ChatEntity

    @Query("DELETE FROM groups WHERE id = :id")
    fun deleteChatById(id: Long)

}