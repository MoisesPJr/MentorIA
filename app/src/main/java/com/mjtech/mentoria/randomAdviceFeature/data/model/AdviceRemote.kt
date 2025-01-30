package com.mjtech.mentoria.randomAdviceFeature.data.model

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class AdviceRemote(
    @Json(name = "slip") val slip: SlipRemote
)
@Keep
@JsonClass(generateAdapter = true)
data class SlipRemote(
    @Json(name = "id") val id: Int,
    @Json(name = "advice") val advice: String
)