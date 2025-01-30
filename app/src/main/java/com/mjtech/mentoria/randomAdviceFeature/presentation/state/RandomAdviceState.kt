package com.mjtech.mentoria.randomAdviceFeature.presentation.state

import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Advice
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Slip

data class RandomAdviceState(
    val advice: Advice= Advice(Slip(0,"")),
    val isLoading:Boolean = true,
    val error: String = "",
    val advices: MutableList<AdviceEntity> = mutableListOf()
)