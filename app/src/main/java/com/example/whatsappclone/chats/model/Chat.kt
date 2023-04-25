package com.example.whatsappclone.chats.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chats(
    val firstName: String,
    val lastName: String,
    val demoText: String,
    val avatar: String,
//    @DrawableRes val avatar: Int,
    val date: String
): Parcelable