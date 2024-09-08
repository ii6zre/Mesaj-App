@file:OptIn(ExperimentalPagerApi::class, ExperimentalPagerApi::class
    , ExperimentalPagerApi::class, ExperimentalPagerApi::class
)

package com.mofalah.msjapp.ui.ui.screen
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.PagerState
import com.mofalah.msjapp.data.INITIAL_SCREEN_INDEX
import com.mofalah.msjapp.ui.ui.components.AppbarComponent
import com.mofalah.msjapp.ui.ui.components.TabsComponent
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {
    val pagerState = rememberPagerState(initialPage = INITIAL_SCREEN_INDEX)
    val scope = rememberCoroutineScope()
    val tabs = listOf("Chats", "Status", "Calls")

    Column {
        AppbarComponent()
        TabsComponent(
            initalIndex = INITIAL_SCREEN_INDEX,
            pagerstate = PagerState,
            onTabSelected = { selectedPage ->
                scope.launch {
                    pagerState.animateScrollToPage(selectedPage)
                }
            }
        )
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            count = tabs.size,
            state = pagerState
        ) { page ->
            when (page) {
                0 -> ChatsScreen()
                1 -> StatusScreen()
                2 -> CallsScreen()
            }
        }
    }
}




@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


