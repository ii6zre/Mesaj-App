package com.mofalah.msjapp.data
import com.mofalah.msjapp.domain.ChatListDataObject
import com.mofalah.msjapp.domain.Message
import com.mofalah.msjapp.domain.MessageDeliveryStatus
import com.mofalah.msjapp.domain.MessageType

val chatList = listOf<ChatListDataObject>(
    ChatListDataObject(
        chatId = 1,
        message = Message(
            content = "Gunaydin Yazilim",
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            type = MessageType.TEXT,
            timestamp = "1:00 AM",
            unreadCount = null
    ),
        userName = "Golden Yazilim"
        ),
    ChatListDataObject(
        chatId = 2,
        message = Message(
            content = "Caku Dunya",
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            type = MessageType.TEXT,
            timestamp = "2:00 AM",
            unreadCount = 1
        ),
        userName = "Bilgisayar Muh.4"
    ),
    ChatListDataObject(
        chatId = 3,
        message = Message(
            content = "16.gun staj",
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            type = MessageType.TEXT,
            timestamp = "2:00 AM",
            unreadCount = 2
        ),
        userName = "Yilmaz bey"
    ),
    ChatListDataObject(
        chatId = 4,
        message = Message(
            content = "staj gel",
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            type = MessageType.TEXT,
            timestamp = "15:00 PM",
            unreadCount = null
        ),
        userName = "Cinar"
    ),
    ChatListDataObject(
        chatId = 5,
        message = Message(
            content = "Nerdesin Mohammed",
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            type = MessageType.TEXT,
            timestamp = "5:00 AM",
            unreadCount = null
        ),
        userName = "Baba"
    )
)