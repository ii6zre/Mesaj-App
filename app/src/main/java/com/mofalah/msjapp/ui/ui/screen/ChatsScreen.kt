package com.mofalah.msjapp.ui.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mofalah.msjapp.data.chatList
import com.mofalah.msjapp.domain.ChatListDataObject
import com.mofalah.msjapp.ui.ui.components.UserDetails
import com.mofalah.msjapp.ui.ui.components.UserImage

@Composable
fun ChatsScreen(){
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
        ,
        verticalArrangement = Arrangement.Center,
    ) {
        item { 
            Spacer(modifier = Modifier.height(10.dp))
        }

        items(chatList){ chatData ->
            ChatListItem(chatData)
        }
    }
}
@Composable
fun ChatListItem(chatData: ChatListDataObject) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        UserImage(chatData.userImage)
        UserDetails(chatData)
    }
}



@Composable
@Preview(showBackground = true)
fun ChatsScreenPreview(){
    ChatsScreen()
}