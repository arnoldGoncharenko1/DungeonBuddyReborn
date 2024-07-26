package com.houseravenstudios.dungeonbuddyreborn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.houseravenstudios.charactersheet.navigation.characterSheetScreen

@Composable
fun DungeonBuddyRebornNavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        characterSheetScreen()
    }
}