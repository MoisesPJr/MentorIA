package com.example.mentoria.randomAdviceFeature.domain.mapper

import com.example.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.example.mentoria.randomAdviceFeature.data.model.SlipRemote
import com.example.mentoria.randomAdviceFeature.domain.model.Advice
import com.example.mentoria.randomAdviceFeature.domain.model.Slip

fun SlipRemote.toDomain(): Slip {
    return Slip(
        id = this.id,
        advice = this.advice
    )
}

fun AdviceRemote.toDomain(): Advice {
    return Advice(
        slip = slip.toDomain()
    )
}