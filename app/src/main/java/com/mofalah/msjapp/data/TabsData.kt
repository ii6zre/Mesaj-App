package com.mofalah.msjapp.data

data class TabsData( val title: String, val unreadCount: Int? )

val tabs = listOf<TabsData>(
    TabsData(Tabs.CHATS.value, null),
    TabsData(Tabs.STATUS.value, null),
    TabsData(Tabs.CALLS.value, 6)
)

enum class Tabs(val value: String) {
    CHATS("Chats"),
    STATUS("Status"),
    CALLS("Calls")
}


const val INITIAL_SCREEN_INDEX = 0