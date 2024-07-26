package com.houseravenstudios.charactersheet.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.houseravenstudios.charactersheet.CharacterSheetRoute

const val CHARACTER_SHEET_ROUTE = "character_sheet_route"

fun NavController.navigateToCharacterSheet() {
    navigate(CHARACTER_SHEET_ROUTE)
}

fun NavGraphBuilder.characterSheetScreen() {
    composable(
        route = CHARACTER_SHEET_ROUTE
    ) {
        CharacterSheetRoute()
    }
}