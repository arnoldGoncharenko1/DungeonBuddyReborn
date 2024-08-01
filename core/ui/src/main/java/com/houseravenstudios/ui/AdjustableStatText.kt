package com.houseravenstudios.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AdjustableStatText(
    statTitle: String,
    statCurrentValue: Int,
    statMaxValue: Int?,
    onAddClicked: () -> Unit,
    onRemoveClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = statTitle)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = "add"
                    )
                },
                onClick = onAddClicked
            )
            Text(text = statCurrentValue.toString())
            if (statMaxValue != null) {
                Text(text = " / $statMaxValue")
            }
            IconButton(
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_remove_24),
                        contentDescription = "remove"
                    )
                },
                onClick = onRemoveClicked
            )
        }
    }
}

@Preview
@Composable
fun AdjustableStatTextNoMaxPreview(){
    AdjustableStatText(
        statTitle = "Temp Health",
        statCurrentValue = 0,
        statMaxValue = null,
        onAddClicked = {},
        onRemoveClicked = {}
    )
}

@Preview
@Composable
fun AdjustableStatTextMaxPreview(){
    AdjustableStatText(
        statTitle = "Health",
        statCurrentValue = 10,
        statMaxValue = 20,
        onAddClicked = {},
        onRemoveClicked = {}
    )
}
