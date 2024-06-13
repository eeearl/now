package com.eeearl.now.data

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class Character(
    @SerialName("mal_id")
    val malId: Int,
    @SerialName("url")
    val url: String,
    @SerialName("images")
    val images: Images,
    @SerialName("name")
    val name: String,
    @SerialName("about")
    val about: String?,
)