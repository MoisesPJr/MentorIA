package com.example.mentoria.randomAdviceFeature.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.mentoria.R
import com.example.mentoria.coreUi.LoadingScreen
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.model.Slip
import com.example.mentoria.randomAdviceFeature.presentation.components.AdviceContent
import com.example.mentoria.randomAdviceFeature.presentation.components.AdviceItem
import com.example.mentoria.randomAdviceFeature.presentation.state.RandomAdviceState
import java.lang.reflect.Modifier

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
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.advice_random_title),
                        color = Color.Black
                    )
                },
            )
        },
        content = { paddingValues ->
            AdviceContent(
                advice = advice,
                refreshClick = refreshAdvice,
                paddingValues = paddingValues,
                shareClick = {  },
                error = error,
                isLoading = isLoading
            )
        }
    )
}