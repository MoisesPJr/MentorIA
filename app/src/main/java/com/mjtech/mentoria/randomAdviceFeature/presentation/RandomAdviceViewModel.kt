package com.mjtech.mentoria.randomAdviceFeature.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mjtech.mentoria.core.utils.ResultData
import com.mjtech.mentoria.favoriteAdvice.domain.mapper.toAdviceEntity
import com.mjtech.mentoria.favoriteAdvice.domain.useCase.SetFavoriteAdviceUseCase
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Advice
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Slip
import com.mjtech.mentoria.randomAdviceFeature.domain.useCase.GetRandomAdviceUseCase
import com.mjtech.mentoria.randomAdviceFeature.presentation.state.RandomAdviceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RandomAdviceViewModel @Inject constructor(
    private val getRandomAdviceUseCase: GetRandomAdviceUseCase,
    private val setFavoriteAdviceUseCase: SetFavoriteAdviceUseCase,

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
                            val advice = resultData.data?.slip?.let {
                                Advice(Slip(it.id, it.advice))
                            } ?: uiState.advice
                            val adviceLog = uiState.advices.toMutableList()
                                .apply { add(advice.toAdviceEntity()) }
                            uiState.copy(
                                isLoading = false,
                                error = "",
                                advice = advice,
                                advices = adviceLog
                            )
                        }

                        is ResultData.Failure -> {
                            uiState.copy(
                                error = "Ocorreu um erro, tente novamente",
                                isLoading = false,
                            )
                        }

                        ResultData.Loading -> {
                            uiState.copy(
                                isLoading = true,
                                advice = Advice(Slip(0, "")),
                                error = "",
                            )
                        }
                    }
                }
        }
    }

    fun setFavoriteAdvice(advice: Advice) {
        viewModelScope.launch {
            setFavoriteAdviceUseCase.invoke(
                params = SetFavoriteAdviceUseCase.Params(
                    adviceEntity = advice.toAdviceEntity()
                )
            )
        }
    }
}