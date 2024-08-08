package com.houseravenstudios.charactersheet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.houseravenstudios.data.classes.model.ClassList
import com.houseravenstudios.ui.R

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
        is CharacterSheetViewModel.UiState.Failed -> DefaultScreen()
        is CharacterSheetViewModel.UiState.Loading -> DefaultScreen()
        is CharacterSheetViewModel.UiState.Success -> DefaultScreen()
    }
}

@Composable
internal fun DefaultScreen() {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("Home", "Character", "Features", "Attacks", "Inventory")

    Box(Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxWidth()) {
            when (tabIndex) {
                0 -> HomeScreen()
                1 -> HomeScreen()
                2 -> HomeScreen()
            }
            Spacer(Modifier.weight(1f))
            TabRow(selectedTabIndex = tabIndex) {
                tabs.forEachIndexed { index, title ->
                    Tab(text = { Text(text = title, fontSize = dimensionResource(id = R.dimen.font_size_tab).value.sp) },
                        selected = tabIndex == index,
                        onClick = { tabIndex = index }
                    )
                }
            }
        }
    }
}

@Composable
internal fun HomeScreen() {
    Row {
        Text(text = "it Worked!")
    }
}

@Preview
@Composable
fun CharacterSheetScreenPreview() {
    CharacterSheetScreen(state = CharacterSheetViewModel.UiState.Success(ClassList(0, emptyList())))
}