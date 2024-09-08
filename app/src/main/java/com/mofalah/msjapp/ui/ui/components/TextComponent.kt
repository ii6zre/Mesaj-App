package com.mofalah.msjapp.ui.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextComponent(
    value: String,
    fontSize: TextUnit,
    color: Color,
    modifier: Modifier?,
    fontWeight: FontWeight? = FontWeight.Normal
){
    if (Modifier != null) {
        Text(
            modifier = Modifier,
            text = value,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = fontSize,
                color = color,
                fontWeight = fontWeight
            )
        )
    }else{
        Text(
            text = value,
            style = androidx.compose.ui.text.TextStyle(
                fontSize = fontSize,
                color = color,
                fontWeight = fontWeight
            )
        )
    }
}


