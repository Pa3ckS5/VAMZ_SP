package com.example.sp_logicgames.Game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sp_logicgames.R

class MasterMind : Game() {
    private val gameLogic = MasterMindGameLogic()
    private val colors = arrayOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan, Color.Magenta)
    private val imageId = R.drawable.image1
    private val nameId = R.string.mastermind

    @Composable
    override fun startGame() {
        val gameLogic = MasterMindGameLogic() // Inicializácia logiky hry

        MaterialTheme {
            Surface(color = Color.White) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MasterMindUI(gameLogic)
                }
            }
        }
    }

    override fun endGame() {
        // Logika na ukončenie hry MasterMind
    }

    override fun getImageId(): Int {
        return imageId
    }

    override fun getNameId(): Int {
        return nameId
    }
}

class MasterMindGameLogic {
    private val colors = arrayOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan, Color.Magenta)
    private val secretCode: List<Color> = generateSecretCode()

    fun guess(code: List<Color>): GuessResult {
        var exactMatches = 0
        var colorMatches = 0

        for (i in code.indices) {
            if (code[i] == secretCode[i]) {
                exactMatches++
            } else if (code.contains(secretCode[i])) {
                colorMatches++
            }
        }

        return GuessResult(exactMatches, colorMatches)
    }

    private fun generateSecretCode(): List<Color> {
        // Generovanie tajného kódu
        // Implementujte podľa potreby
        return emptyList()
    }
}

data class GuessResult(val exactMatches: Int, val colorMatches: Int)
