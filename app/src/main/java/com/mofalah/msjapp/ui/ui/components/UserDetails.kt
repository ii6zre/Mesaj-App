package com.mofalah.msjapp.ui.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mofalah.msjapp.domain.ChatListDataObject
import com.mofalah.msjapp.domain.Message
import com.mofalah.msjapp.domain.MessageDeliveryStatus
import com.mofalah.msjapp.domain.MessageType
import com.mofalah.msjapp.ui.ui.themes.HighlightGreen

@Composable
fun UserDetails(chatData: ChatListDataObject) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(start = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        MessageHeader(chatData)
        MessageSubSection(chatData)
    }
}

@Composable
fun MessageSubSection(chatData: ChatListDataObject) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextComponent(
            modifier = Modifier.weight(1f),
            value = chatData.message.content,
            fontSize = 16.sp,
            color = Color.Gray,
        )
        chatData.message.unreadCount?.also {
            CircularCount(
                unreadCount = it.toString(),
                backgroundColor = Color.Green,
                textColor = Color.White
            )
        }
    }
}

@Composable
fun MessageHeader(chatData: ChatListDataObject) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextComponent(
            value = chatData.userName,
            fontSize = 16.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f),
            fontWeight = FontWeight.SemiBold
        )
        TextComponent(
            value = chatData.message.timestamp,
            fontSize = 12.sp,
            color = if((chatData.message.unreadCount?:0) >0) HighlightGreen else Color.Gray,
            modifier = null
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserDetailsPreview(){
    UserDetails(chatData = ChatListDataObject(
        chatId = 3,
        message = Message(
            content = "16.gun staj",
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            type = MessageType.TEXT,
            timestamp = "2:00 AM"
        ),
        userName = "Yilmaz bey"
    )
    )
}
@Preview(showBackground = true)
@Composable
fun MessageHeaderPreview(){
    MessageHeader(chatData = ChatListDataObject(
        chatId = 3,
        message = Message(
            content = "16.gun staj",
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            type = MessageType.TEXT,
            timestamp = "2:00 AM"
        ),
        userName = "Golden Firma"
    ))
}
@Preview(showBackground = true)
@Composable
fun MessageSubSectionPreview(){
    MessageSubSection(chatData = ChatListDataObject(
        chatId = 3,
        message = Message(
            content = "16.gun staj",
            deliveryStatus = MessageDeliveryStatus.DELIVERED,
            type = MessageType.TEXT,
            timestamp = "2:00 AM"
        ),
        userName = "Mohammed"
    ))
}