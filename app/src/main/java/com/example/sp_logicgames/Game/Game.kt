package com.example.sp_logicgames.Game

import androidx.compose.runtime.Composable

abstract class Game {

    @Composable
    abstract fun startGame()
    abstract fun endGame()
    abstract fun getImageId(): Int
    abstract fun getNameId(): Int
}