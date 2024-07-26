package com.houseravenstudios.charactersheet

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

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
    Row {
        Text(text = "It worked!")
    }
}