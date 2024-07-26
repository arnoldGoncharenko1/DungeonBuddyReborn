package com.houseravenstudios.dungeonbuddyreborn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.houseravenstudios.charactersheet.navigation.CHARACTER_SHEET_ROUTE
import com.houseravenstudios.dungeonbuddyreborn.navigation.DungeonBuddyRebornNavHost
import com.houseravenstudios.dungeonbuddyreborn.ui.theme.DungeonBuddyRebornTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            DungeonBuddyRebornTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DungeonBuddyRebornNavHost(navController = navController, startDestination = CHARACTER_SHEET_ROUTE)
                }
            }
        }
    }
}