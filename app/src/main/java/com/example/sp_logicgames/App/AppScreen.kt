package com.example.sp_logicgames.App
sealed class AppScreen(val route:String) {
    object StartScreen: AppScreen("StartScreen")
    object Menu: AppScreen("Menu")
    object Info: AppScreen("Info")
    object Mastermind: AppScreen("Mastermind")

}