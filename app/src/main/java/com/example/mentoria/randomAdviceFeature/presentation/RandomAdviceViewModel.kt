package com.example.mentoria.randomAdviceFeature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mentoria.core.utils.ResultData
import com.example.mentoria.core.utils.translateText
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.model.Slip
import com.example.mentoria.randomAdviceFeature.domain.useCase.GetRandomAdviceUseCase
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

    fun getRandomAdvice() {
        viewModelScope.launch {
            getRandomAdviceUseCase()
                .collect { resultData ->
                    uiState = when (resultData) {
                        is ResultData.Success -> {
                            uiState.copy(
                                isLoading = false,
                                error = "",
                                advice = resultData.data?.slip?.let {
                                    Advice(Slip(it.id,it.advice))
                                } ?: uiState.advice
                            )
                        }

                        is ResultData.Failure -> {
                            uiState.copy(
                                error = "Ocorreu um erro, tente novamente",
                                isLoading = false
                            )
                        }

                        ResultData.Loading -> {
                            uiState.copy(
                                isLoading = true,
                                advice = Advice(Slip(0,"")),
                                error = ""

                            )
                        }
                    }
                }
        }
    }
}