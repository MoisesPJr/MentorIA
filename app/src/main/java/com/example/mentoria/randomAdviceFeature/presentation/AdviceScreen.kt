package com.example.mentoria.randomAdviceFeature.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.mentoria.randomAdviceFeature.presentation.components.AdviceContent
import com.example.mentoria.randomAdviceFeature.presentation.state.RandomAdviceState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdviceScreen(
    uiState: RandomAdviceState,
    refreshAdvice: () -> Unit
) {

    val advice = uiState.advice
    val isLoading = uiState.isLoading
    val error = uiState.error


    Scaffold(
        content = { paddingValues ->
            AdviceContent(
                advice = advice,
                refreshClick = refreshAdvice,
                paddingValues = paddingValues,
                error = error,
                isLoading = isLoading
            )
        }
    )
}