package com.example.mentoria.randomAdviceFeature.domain.model

data class Advice(
    val slip: Slip
)

data class Slip(
    val id: Int,
    val advice: String
)