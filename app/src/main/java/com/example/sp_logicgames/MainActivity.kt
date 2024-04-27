package com.example.sp_logicgames

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sp_logicgames.App.LogicGamesApp
//import androidx.activity.enableEdgeToEdge
import com.example.sp_logicgames.Design.SP_LogicGamesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SP_LogicGamesTheme {
                val app = LogicGamesApp()
                app.startApp()


            }
        }
    }
}