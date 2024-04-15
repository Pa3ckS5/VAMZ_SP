package com.example.sp_logicgames

import androidx.compose.runtime.Composable

abstract class Game {
    @Composable
    abstract fun startGame()
    abstract fun endGame()
}