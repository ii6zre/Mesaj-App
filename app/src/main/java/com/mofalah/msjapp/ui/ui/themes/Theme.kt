package com.mofalah.msjapp.ui.ui.themes


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.platform.LocalView
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorScheme = darkColorScheme(
    primary = Gray,
    secondary = LightGreen,
    background = LightGray,
    tertiary = White
)

private val LightColorScheme = lightColorScheme(
    primary = Green200,
    secondary = LightGreen,
    background = White,
    tertiary = White

)

@Composable
fun MsjAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode){
        val systemUiController = rememberSystemUiController()
        val statusBarColor = if(isSystemInDarkTheme()){
            Gray
        } else
            Green200
    }

    val navgationBarColor = if(isSystemInDarkTheme()){
        LightGray
    }else
        White

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}