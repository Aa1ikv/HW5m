package com.example.lesson4.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Origin(
    @SerialName("name")
    val name: String? = null,
    @SerialName("url")
    val url: String? = null
)