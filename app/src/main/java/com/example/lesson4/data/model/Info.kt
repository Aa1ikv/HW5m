package com.example.lesson4.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Info(
    @SerialName("count")
    val count: Int? = null,
    @SerialName("pages")
    val pages: Int? = null,
    @SerialName("next")
    val next: String? = null,
    @SerialName("prev")
    val prev: String? = null
)