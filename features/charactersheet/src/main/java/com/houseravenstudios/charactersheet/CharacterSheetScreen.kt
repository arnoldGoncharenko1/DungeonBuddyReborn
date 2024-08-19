@file:OptIn(ExperimentalMaterial3Api::class)

package com.houseravenstudios.charactersheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.houseravenstudios.charactersheet.CharacterSheetViewModel.UiState.Success
import com.houseravenstudios.data.classes.model.ClassList
import com.houseravenstudios.ui.AdjustableStatText
import com.houseravenstudios.ui.PlayerStatCircle
import com.houseravenstudios.ui.R
import com.houseravenstudios.ui.STROKE_WIDTH
import com.houseravenstudios.ui.StatText

@Composable
internal fun CharacterSheetRoute(
    viewModel: CharacterSheetViewModel = hiltViewModel()
) {
    CharacterSheetScreen(viewModel.uiState)
}

@Composable
internal fun CharacterSheetScreen(
    state: CharacterSheetViewModel.UiState
) {
    when (state) {
        is CharacterSheetViewModel.UiState.Failed -> ErrorScreen()
        is CharacterSheetViewModel.UiState.Loading -> LoadingScreen()
        is Success -> SuccessScreen(state)
    }
}

@Composable
internal fun ErrorScreen() {

}

@Composable
internal fun LoadingScreen() {

}

@Composable
internal fun SuccessScreen(state: Success) {
    var tabIndex by rememberSaveable { mutableIntStateOf(0) }
    val tabs = listOf("Home", "Character", "Features", "Attacks", "Inventory")

    Column(modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        TopAppBar(
            title = { Text(text = "Character")},
            windowInsets = WindowInsets(
                top = dimensionResource(id = R.dimen.window_insets),
                bottom = dimensionResource(id = R.dimen.window_insets)
        ))
        when (tabIndex) {
            0 -> HomeScreen()
            1 -> CharacterScreen()
            2 -> Features()
        }
        TabRow(selectedTabIndex = 0) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(text = title, fontSize = dimensionResource(id = R.dimen.font_size_tab).value.sp) },
                    selected = index == tabIndex,
                    onClick = {
                        tabIndex = index
                    }
                )
            }
        }
    }
}

@Composable
internal fun HomeScreen() {
    Column {
        Text(text = "it Worked!")
    }
}

@Composable
internal fun Features() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        var profAndLanguageValue by rememberSaveable { mutableStateOf("") }
        var featuresAndTraitsValue by rememberSaveable { mutableStateOf("") }

        Text(text = "Proficiencies and Languages", fontSize = dimensionResource(id = R.dimen.font_size_features).value.sp)
        TextField(
            value = profAndLanguageValue,
            onValueChange = { profAndLanguageValue = it },
            label = { Text("Enter text") },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Text(text = "Features and Traits", fontSize = dimensionResource(id = R.dimen.font_size_features).value.sp)
        TextField(
            value = featuresAndTraitsValue,
            onValueChange = { featuresAndTraitsValue = it },
            label = { Text("Enter text") },
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
    }
}

@Composable
internal fun CharacterScreen() {
    StrDexConStatRow()
    IntWisChaStatRow()

    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.9f)) {
        ProfPerceptionRow()
        InitAcSpeedRow()
        HealthStatRow()
    }
}

@Composable
internal fun StrDexConStatRow() {
    Row(horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp, top = 24.dp)) {
        PlayerStatCircle(statTitle = "Strength", statValue = 20, statModifier = "+5", statColor = Color.Red)
        PlayerStatCircle(statTitle = "Dexterity", statValue = 20, statModifier = "+5", statColor = Color.Green)
        PlayerStatCircle(statTitle = "Constitution", statValue = 20, statModifier = "+5", statColor = Color.Cyan)
    }
}

@Composable
internal fun IntWisChaStatRow() {
    Row(horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth()) {
        PlayerStatCircle(statTitle = "Intelligence", statValue = 20, statModifier = "+5", statColor = Color.Yellow)
        PlayerStatCircle(statTitle = "Wisdom", statValue = 20, statModifier = "+5", statColor = Color.Magenta)
        PlayerStatCircle(statTitle = "Charisma", statValue = 20, statModifier = "+5", statColor = Color.Blue)
    }
}

@Composable
internal fun ProfPerceptionRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        StatText(statTitle = "Proficiency Bonus:", statValue = "+2")
        StatText(statTitle = "Passive Perception:", statValue = "+2")
    }
}

@Composable
internal fun HealthStatRow() {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        AdjustableStatText(statTitle = "Hit Dice", statCurrentValue = 0, onAddClicked = {}, onRemoveClicked = {}, extraInfo = "1d10")
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AdjustableStatText(statTitle = "Temp Health", statCurrentValue = 0, onAddClicked = {}, onRemoveClicked = {}, modifier = Modifier.padding(bottom = 8.dp))
            AdjustableStatText(statTitle = "Health", statCurrentValue = 20, statMaxValue = 20, onAddClicked = {}, onRemoveClicked = {})
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.drawBehind {
                drawRect(color = Color.Gray, style = Stroke(width = STROKE_WIDTH))
            }
        ) {
            Text(text = "Death saves")
            DeathSaveRow(title = "Successes", rowCount = 2)
            DeathSaveRow(title = "Failures", rowCount = 2)
        }
    }
}

@Composable
internal fun InitAcSpeedRow() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        StatText(statTitle = "Initiative:", statValue = "+2")
        StatText(statTitle = "AC:", statValue = "15")
        StatText(statTitle = "Speed:", statValue = "30ft")
    }
}

@Composable
internal fun DeathSaveRow(title: String, rowCount: Int) {
    Text(text = title)
    Row {
        for (i in 2 downTo 0) {
            Icon(
                painter =
                    if(i + 1 <= rowCount)
                        painterResource(id = R.drawable.baseline_radio_button_checked_24)
                    else
                        painterResource(id = R.drawable.baseline_radio_button_unchecked_24),
                contentDescription = "add"
            )
        }
    }
}

@Preview
@Composable
fun CharacterSheetScreenPreview() {
    CharacterSheetScreen(state = Success(ClassList(0, emptyList())))
}