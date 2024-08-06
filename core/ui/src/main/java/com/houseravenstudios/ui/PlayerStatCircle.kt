package com.houseravenstudios.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlayerStatCircle(
    statTitle: String,
    statValue: Int,
    statModifier: String,
    statColor: Color = Color.Red,
    modifier: Modifier = Modifier) {
    
    Box(modifier = Modifier.size(100.dp)) {
        Canvas(modifier = Modifier.fillMaxSize(), onDraw = {
            drawCircle(color = statColor)
        })
        StatText(
            statTitle = statTitle,
            statValue = "$statValue $statModifier",
            modifier = Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun SelectOptionPreview(){
    PlayerStatCircle(
        statTitle = "Strength",
        statValue = 20,
        statColor = Color.Yellow,
        statModifier = "+5",
        modifier = Modifier.fillMaxHeight()
    )
}
