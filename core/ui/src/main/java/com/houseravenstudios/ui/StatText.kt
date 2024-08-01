package com.houseravenstudios.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StatText(
    statTitle: String,
    statValue: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = statTitle)
        Text(text = statValue)
    }
}

@Preview
@Composable
fun StatTextPreview(){
    StatText(
        statTitle = "Proficiency Bonus:",
        statValue = "+2"
    )
}
