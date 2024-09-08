package com.mofalah.msjapp.domain

import com.mofalah.msjapp.R

data class ChatListDataObject(
    val chatId: Int,
    val message: Message,
    val userName: String,
    val userImage : Int = R.drawable.ic_user
)

data class Message(
    val content: String,
    val deliveryStatus: MessageDeliveryStatus,
    val type : MessageType,
    val timestamp: String,
    val unreadCount: Int? = null
)

enum class MessageDeliveryStatus{
    DELIVERED,
    READ,
    PANDING,
    ERROR
}
enum class MessageType {
    TEXT,
    IMAGE,
    VIDEO,
    AUDIO
}