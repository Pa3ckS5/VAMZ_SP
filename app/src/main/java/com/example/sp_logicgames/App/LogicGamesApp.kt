package com.example.sp_logicgames.App

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.theme.MenuUI
import com.example.sp_logicgames.Game.MasterMind

class LogicGamesApp {
    val masterMind = MasterMind()
    val masterMind2 = MasterMind()
    val games = listOf(masterMind, masterMind2)

    @Composable
    fun startApp() {

        val navController = rememberNavController()
        NavHost(navController=navController,
            startDestination = AppScreen.StartScreen.route
        ){

        }

    }
}