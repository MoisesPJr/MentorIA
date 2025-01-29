package com.example.mentoria.favoriteAdvice.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mentoria.core.utils.ResultData
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.favoriteAdvice.domain.useCase.DeleteFavoriteAdviceUseCase
import com.example.mentoria.favoriteAdvice.domain.useCase.GetFavoriteAdviceUseCase
import com.example.mentoria.favoriteAdvice.domain.useCase.SetFavoriteAdviceUseCase
import com.example.mentoria.favoriteAdvice.presentation.state.FavoriteAdviceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesAdviceViewModel @Inject constructor(
    private val getFavoriteAdviceUseCase: GetFavoriteAdviceUseCase,
    private val deleteRandomAdviceUseCase: DeleteFavoriteAdviceUseCase
) : ViewModel() {

    var uiState by mutableStateOf(FavoriteAdviceState())
        private set

    init {
        getFavoriteAdvice()
    }

    fun getFavoriteAdvice() {
        viewModelScope.launch {
            getFavoriteAdviceUseCase.invoke().collectLatest { resultData ->
                uiState = when (resultData) {
                    is ResultData.Success -> {
                        uiState.copy(
                            advices = resultData.data!!,
                            isLoading = false,
                            error = "",
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
                            advices = emptyList(),
                            error = ""

                        )
                    }
                }
            }
        }
    }


    fun deleteFavoriteAdvice(advice: AdviceEntity) {
        viewModelScope.launch {
            deleteRandomAdviceUseCase.invoke(
                params = DeleteFavoriteAdviceUseCase.Params(
                    adviceEntity = advice
                )
            )
            getFavoriteAdvice()
        }
    }


}