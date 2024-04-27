package com.example.sp_logicgames.Game

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sp_logicgames.R


@Composable
fun MasterMindUI(gameLogic: MasterMindGameLogic) {
    var guessedCode by remember { mutableStateOf(emptyList<Color>()) }
    var guessResult by remember { mutableStateOf<GuessResult?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // UI komponenty pre výber farieb
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val colors = arrayOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan, Color.Magenta)
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(color)
                        .clickable {
                            guessedCode = guessedCode + color
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // UI komponent pre zobrazenie hádaného kódu
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            guessedCode.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(color)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tlačidlo na odoslanie hádaného kódu
        Button(
            onClick = {
                guessResult = gameLogic.guess(guessedCode)
            }
        ) {
            Text(text = "Guess")
        }

        // Zobrazenie výsledku hádania
        guessResult?.let { result ->
            Text(
                text = "Exact Matches: ${result.exactMatches}, Color Matches: ${result.colorMatches}",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}