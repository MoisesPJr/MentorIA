package com.example.mentoria.favoriteAdvice.presentation.state

import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.model.Slip

data class FavoriteAdviceState(
    val advices: List<AdviceEntity> = emptyList(),
    val isLoading:Boolean = true,
    val error: String = "",
)