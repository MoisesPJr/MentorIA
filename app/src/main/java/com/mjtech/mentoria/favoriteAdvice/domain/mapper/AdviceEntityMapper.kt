package com.mjtech.mentoria.favoriteAdvice.domain.mapper

import com.mjtech.mentoria.favoriteAdvice.data.model.AdviceEntityRemote
import com.mjtech.mentoria.favoriteAdvice.domain.AdviceEntity
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Advice
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Slip

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

fun AdviceEntity.toAdvice(): Advice {
    return Advice(
        Slip(
            id = id,
            advice = advice
        )
    )
}

fun Advice.toAdviceEntity(): AdviceEntity {
    return AdviceEntity(
        id = slip.id,
        advice = slip.advice
    )
}