package com.mjtech.mentoria.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mjtech.mentoria.favoriteAdvice.presentation.FavoritesAdviceScreen
import com.mjtech.mentoria.favoriteAdvice.presentation.FavoritesAdviceViewModel
import com.mjtech.mentoria.randomAdviceFeature.presentation.AdviceScreen
import com.mjtech.mentoria.randomAdviceFeature.presentation.RandomAdviceViewModel

@Composable
fun NavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = NavigationItems.RandomAdvice.route
    ) {
        composable(NavigationItems.RandomAdvice.route) {
            val viewmodel: RandomAdviceViewModel = hiltViewModel()
            val uiState = viewmodel.uiState
            val setFavorite = viewmodel::setFavoriteAdvice

            AdviceScreen(uiState = uiState,
                refreshAdvice = { viewmodel.getRandomAdvice() },
                setFavoriteAdvice =  setFavorite ,
                navigateToFavoriteScreen = {
                    navController.navigate(NavigationItems.FavoriteAdvice.route)
                })
        }

        composable(NavigationItems.FavoriteAdvice.route) {
            val viewmodel: FavoritesAdviceViewModel = hiltViewModel()
            val uiState = viewmodel.uiState
            val deleteFavorite = viewmodel::deleteFavoriteAdvice
            FavoritesAdviceScreen(
                uiState = uiState,
                removeFavorite = deleteFavorite,
            )
        }
    }
}