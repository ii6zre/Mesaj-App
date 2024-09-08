package com.mofalah.msjapp.ui.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mofalah.msjapp.R
import me.nikhilchaudhari.library.neumorphic

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppbarComponent(){
    Row (
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .height(99.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(start = 16.dp, end = 16.dp, top = 28.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ){
        Text(text = stringResource(id = R.string.MesajApp_title),
            style = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = if(isSystemInDarkTheme())
                    androidx.compose.ui.graphics.Color.Gray
                else
                    androidx.compose.ui.graphics.Color.White)
            )

        Spacer(modifier = androidx.compose.ui.Modifier.weight(1f))
        IconComponent(drawableId = R.drawable.ic_camera)
        Spacer(modifier = androidx.compose.ui.Modifier.size(16.dp))
        IconComponent(drawableId = R.drawable.ic_search)
        Spacer(modifier = androidx.compose.ui.Modifier.size(16.dp))
        IconComponent(drawableId = R.drawable.ic_menu)
    }
    Spacer(modifier = androidx.compose.ui.Modifier.size(10.dp))
}

@Composable
fun IconComponent(drawableId: Int){
    Icon(
        painter = painterResource(id = drawableId)
        , contentDescription = "" ,
    tint = if(isSystemInDarkTheme())
        androidx.compose.ui.graphics.Color.Gray
    else
        androidx.compose.ui.graphics.Color.White)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun BottumbarComponentPreview() {
    AppbarComponent()
}