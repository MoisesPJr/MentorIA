package com.example.mentoria.randomAdviceFeature.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mentoria.randomAdviceFeature.domain.useCase.GetRandomAdviceUseCase
import com.example.mentoria.randomAdviceFeature.domain.useCase.GetRandomAdviceUseCaseImpl
import com.example.mentoria.randomAdviceFeature.presentation.state.RandomAdviceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RandomAdviceViewModel @Inject constructor(
    private val getRandomAdviceUseCase: GetRandomAdviceUseCase
) : ViewModel() {

    var uiState by mutableStateOf(RandomAdviceState())
        private set

    init {
        getRandomAdvice()
    }

    private fun getRandomAdvice() {
        uiState.copy(isLoading = true)
        viewModelScope.launch {
            getRandomAdviceUseCase()
                .collect { advice ->
                    uiState = uiState.copy(advice = advice, isLoading = false)
                }
        }
    }
}