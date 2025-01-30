package com.mjtech.mentoria.randomAdviceFeature.domain.mapper

import com.mjtech.mentoria.randomAdviceFeature.data.model.AdviceRemote
import com.mjtech.mentoria.randomAdviceFeature.data.model.SlipRemote
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Advice
import com.mjtech.mentoria.randomAdviceFeature.domain.model.Slip

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