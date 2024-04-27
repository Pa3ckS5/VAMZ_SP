package com.example.sp_logicgames.App

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.theme.MenuUI
import com.example.sp_logicgames.Game.MasterMind
import com.example.sp_logicgames.Game.MasterMindUI
import com.example.sp_logicgames.Start.StartScreenUI

@Composable
fun NavHostUI(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.StartScreen.route,
        modifier = modifier
    ) {
        composable(AppScreen.StartScreen.route){
            StartScreenUI(navController = navController)
        }
        composable(AppScreen.Menu.route){
            MenuUI(navController = navController)
        }
        composable(AppScreen.Mastermind.route)) {
            MasterMindUI(navController = navController, backStackEntry=backStackEntry)
        }
    }