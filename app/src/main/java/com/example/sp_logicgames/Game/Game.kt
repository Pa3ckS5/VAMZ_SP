package com.example.sp_logicgames.Game

import androidx.compose.runtime.Composable
import com.example.sp_logicgames.App.AppScreen

abstract class Game {

    @Composable
    abstract fun startGame()
    abstract fun endGame()
    abstract fun getImageId(): Int
    abstract fun getNameId(): Int

    abstract fun navigate()
}