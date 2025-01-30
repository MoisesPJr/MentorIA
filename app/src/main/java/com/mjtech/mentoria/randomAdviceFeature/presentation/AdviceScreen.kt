package com.mjtech.mentoria.randomAdviceFeature.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Advice
import com.mjtech.mentoria.randomAdviceFeature.presentation.components.AdviceContent
import com.mjtech.mentoria.randomAdviceFeature.presentation.state.RandomAdviceState

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
    val advices = uiState.advices


    Scaffold(content = { paddingValues ->
        AdviceContent(
            advice = advice,
            refreshClick = refreshAdvice,
            paddingValues = paddingValues,
            error = error,
            isLoading = isLoading,
            setFavoriteAdvice = setFavoriteAdvice,
            navigateToFavoriteScreen = navigateToFavoriteScreen,
            advices = advices
        )
    })
}