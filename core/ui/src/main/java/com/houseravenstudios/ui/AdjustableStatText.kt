package com.houseravenstudios.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

const val STROKE_WIDTH = 2f

@Composable
fun AdjustableStatText(
    statTitle: String,
    statCurrentValue: Int,
    statMaxValue: Int? = null,
    extraInfo: String? = null,
    onAddClicked: () -> Unit,
    onRemoveClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.drawBehind {
            drawRect(color = Color.Gray, style = Stroke(width = STROKE_WIDTH))
        }
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
        if (extraInfo != null) {
            Text(
                text = extraInfo,
                modifier = Modifier.padding(
                    bottom = dimensionResource(id = R.dimen.margin_12)
                ))
        }
    }
}

@Preview
@Composable
fun AdjustableStatTextNoMaxPreview(){
    AdjustableStatText(
        statTitle = "Temp Health",
        statCurrentValue = 0,
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
        extraInfo = "Extra info",
        onAddClicked = {},
        onRemoveClicked = {}
    )
}