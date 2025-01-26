package com.example.mentoria.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mentoria.randomAdviceFeature.presentation.AdviceScreen
import com.example.mentoria.randomAdviceFeature.presentation.RandomAdviceViewModel

@Composable
fun NavigationGraph(navController: NavHostController){

    NavHost(
        navController= navController,
        startDestination = NavigationItems.RandomAdvice.route
    ){
        composable(NavigationItems.RandomAdvice.route){

            val viewmodel : RandomAdviceViewModel = hiltViewModel()
            val uiState =  viewmodel.uiState
            AdviceScreen(
                uiState = uiState,
                navigateToSearchAdvice = {}
            )
        }
    }
}