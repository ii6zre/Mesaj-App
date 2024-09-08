@file:OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
package com.mofalah.msjapp.ui.ui.components
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.mofalah.msjapp.data.TabsData
import com.mofalah.msjapp.data.tabs

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TabsComponent(
    initalIndex: Int = 0,
    pagerstate: PagerState.Companion,
    onTabSelected: (Int) -> Unit
){
    var selectedIndex by remember {
        mutableStateOf(initalIndex)
    }

    TabRow(
        selectedTabIndex = selectedIndex,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
            .clip(CircleShape),
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.tertiary,
        indicator = { tabPositions ->
            androidx.compose.material3.TabRowDefaults.Indicator(
                modifier = androidx.compose.ui.Modifier.tabIndicatorOffset(tabPositions[selectedIndex]),
                color = MaterialTheme.colorScheme.tertiary,
                height = 4.dp)
        }
    ) {
        tabs.forEachIndexed { index, tabData ->
            Tab(
                selected = index == selectedIndex,
                onClick = {
                    selectedIndex = index
                    onTabSelected(selectedIndex)
                },
                text = {
                    TabContent(tabData = tabData)
                }
            )
        }
    }
}

@Composable
fun TabContent(tabData: TabsData){
    if (tabData.unreadCount == null) {
        TabTitle(title = tabData.title)
    }else
        TabWithUnreadCount(tabData = tabData)
}

@Composable
fun TabTitle(title: String){
    Text(
        text = title,
        style = androidx.compose.ui.text.TextStyle(fontSize = 16.sp))
}

@Composable
fun TabWithUnreadCount(tabData: TabsData){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
       TabTitle(title = tabData.title)
        tabData?.unreadCount?.also  { unreadCount ->
            CircularCount(
                unreadCount = unreadCount.toString(),
                backgroundColor = Color.Green,
                textColor = Color.White
            )
        }
    }
}

