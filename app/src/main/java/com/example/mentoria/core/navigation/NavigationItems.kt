package com.example.mentoria.core.navigation

sealed class NavigationItems(val route: String) {


    data object RandomAdvice: NavigationItems("random_advice_screen")
    data object FavoriteAdvice: NavigationItems("favorite_advice_screen")

}