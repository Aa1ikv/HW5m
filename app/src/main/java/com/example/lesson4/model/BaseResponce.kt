package com.example.lesson4.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponce(
    @SerialName("info")
    val info: Info? = null,
    @SerialName("results")
    val characters: List<Character>? = null
)
