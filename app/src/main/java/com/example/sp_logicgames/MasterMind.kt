package com.example.sp_logicgames

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MasterMind : Game() {
    private val gameLogic = MasterMindGameLogic()
    private val colors = arrayOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan, Color.Magenta)

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
                    MasterMindGameUI(gameLogic)
                }
            }
        }
    }

    override fun endGame() {
        // Logika na ukončenie hry MasterMind
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

@Composable
fun MasterMindGameUI(gameLogic: MasterMindGameLogic) {
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




//package com.example.sp_logicgames
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.unit.dp
//
//
//class MasterMind : Game() {
//    private val gameLogic = MasterMindGameLogic()
//    private val colors =  arrayOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan, Color.Magenta)
//
//    @Composable
//    override fun startGame() {
//        val gameLogic = MasterMindGameLogic() // Inicializácia logiky hry
//
//        setContent {
//            MaterialTheme {
//                Surface(color = Color.White) {
//                    Column(
//                        modifier = Modifier.fillMaxSize(),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        MasterMindGameUI(gameLogic)
//                    }
//                }
//            }
//        }
//    }
//
//    override fun endGame() {
//        // Logika na ukončenie hry MasterMind
//    }
//}
//
//class MasterMindGameLogic {
//    // Logika hry MasterMind
//    private val colors =  arrayOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan, Color.Magenta)
//    private val secretCode: List<Color> = this.generateSecretCode()
//
//    fun guess(code: List<Color>): GuessResult {
//        // Logika pre vyhodnotenie hadaného kódu
//        var exactMatches = 0
//        var colorMatches = 0
//
//        for (i in code.indices) {
//            if (code[i] == secretCode[i]) {
//                exactMatches++
//            } else if (code[i] in secretCode) {
//                colorMatches++
//            }
//        }
//
//        if (exactMatches > 0) {return GuessResult.COLOR_MATCH}
//        return GuessResult.WRONG
//    }
//
//    fun generateSecretCode(): List<Color> {
//        // Generovanie tajného kódu
//        val secretCode = mutableListOf<Color>()
//        repeat(4) {
//            secretCode.add(colors.random())
//        }
//        return secretCode
//    }
//
//}
//
//enum class Colors {
//    RED, BLUE, GREEN, YELLOW, ORANGE, PURPLE
//}
//
//enum class GuessResult {
//    EXACT_MATCH, COLOR_MATCH, WRONG
//}
//
//@Composable
//fun MasterMindGameUI(gameLogic: MasterMindGameLogic) {
//    var guess by remember { mutableStateOf(listOf<Color>()) }
//    var guessResult by remember { mutableStateOf<GuessResult?>(null) }
//
//    Column {
//        Text("Welcome to MasterMind!", style = MaterialTheme.typography.titleLarge)
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Zobrazenie dosky s farebnými políčkami pre hádanie
//        MasterMindBoard(guess) { color ->
//            guess = guess.toMutableList().apply { add(color) }
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Tlačidlo pre potvrdenie hádania
//        Button(onClick = {
//            guessResult = gameLogic.guess(guess)
//        }) {
//            Text("Guess")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Zobrazenie výsledku hádania
//        guessResult?.let { result ->
//            Text(
//                when (result) {
//                    GuessResult.EXACT_MATCH -> "You guessed the code!"
//                    GuessResult.COLOR_MATCH -> "Some colors are correct, but not in the right position."
//                    GuessResult.WRONG -> "Wrong guess, try again."
//                },
//                style = MaterialTheme.typography.titleLarge
//            )
//        }
//    }
//}
//
//@Composable
//fun MasterMindBoard(guess: List<Color>, onColorSelected: (Color) -> Unit) {
//    // Zobrazenie hracej dosky s farebnými políčkami pre hádanie
//    Row {
//        val color1 = Color
//        val colors =  arrayOf(Color.Red, Color.Blue, Color.Green, Color.Yellow, Color.Cyan, Color.Magenta)
//        for (color in colors) {
//            Box(
//                modifier = Modifier
//                    .size(50.dp)
//                    .background(color)
//                    .clickable { onColorSelected(color) }
//            )
//        }
//    }
//}

//fun getColor(color: Color): Color {
//    return when (color) {
//        Color.RED -> Color.Red
//        Color.BLUE -> Color.Blue
//        Color.GREEN -> Color.Green
//        Color.YELLOW -> Color.Yellow
//        Color.ORANGE -> Color.DarkOrange
//        Color.PURPLE -> Color.Purple
//    }
//}