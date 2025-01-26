package com.example.mentoria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.mentoria.core.navigation.MainScreen
import com.example.mentoria.ui.theme.MentorIATheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MentorIATheme {
                MainScreen(navController = rememberNavController())
            }
        }
    }
}
