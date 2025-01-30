package com.mjtech.mentoria.favoriteAdvice.presentation.state

import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity

data class FavoriteAdviceState(
    val advices: List<AdviceEntity> = emptyList(),
    val isLoading:Boolean = true,
    val error: String = "",
)