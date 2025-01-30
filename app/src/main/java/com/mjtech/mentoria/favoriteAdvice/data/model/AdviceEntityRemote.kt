package com.mjtech.mentoria.favoriteAdvice.data.model

import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "advice")
@Keep
@JsonClass(generateAdapter = true)
data class AdviceEntityRemote(
    @PrimaryKey
    @Json(name = "id") val id: Int,
    @Json(name = "advice") val advice: String,
)