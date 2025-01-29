package com.example.mentoria.randomAdviceFeature.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.presentation.components.AdviceContent
import com.example.mentoria.randomAdviceFeature.presentation.state.RandomAdviceState

@Composable
fun AdviceScreen(
    uiState: RandomAdviceState,
    refreshAdvice: () -> Unit,
    setFavoriteAdvice: (Advice) -> Unit,
    navigateToFavoriteScreen: () -> Unit
) {

    val advice = uiState.advice
    val isLoading = uiState.isLoading
    val error = uiState.error
    val isFavorite = uiState.isFavorite


    Scaffold(content = { paddingValues ->
        AdviceContent(
            advice = advice,
            refreshClick = refreshAdvice,
            paddingValues = paddingValues,
            error = error,
            isLoading = isLoading,
            setFavoriteAdvice = setFavoriteAdvice,
            navigateToFavoriteScreen = navigateToFavoriteScreen,
            isFavoriteAdvice = isFavorite
        )
    })
}