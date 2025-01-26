package com.example.mentoria.randomAdviceFeature.presentation.state

import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.model.Slip

data class RandomAdviceState(
    val advice: Advice= Advice(Slip(0,"")),
    val isLoading:Boolean = true,
    val error: String = "",
)