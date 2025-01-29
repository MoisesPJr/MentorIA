package com.example.mentoria.favoriteAdvice.domain.mapper

import com.example.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.example.mentoria.favoriteAdvice.domain.AdviceEntity
import com.example.mentoria.randomAdviceFeature.domain.model.Advice

fun AdviceEntityRemote.toDomain(): AdviceEntity {
    return AdviceEntity(
        id = id,
        advice = advice,
    )
}

fun AdviceEntity.toRemote(): AdviceEntityRemote {
    return AdviceEntityRemote(
        id = id,
        advice = advice
    )
}

fun Advice.toAdviceEntity(): AdviceEntity {
    return AdviceEntity(
        id = slip.id,
        advice = slip.advice
    )
}