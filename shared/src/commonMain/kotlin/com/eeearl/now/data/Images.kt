package com.eeearl.now.data

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class Images(
    @SerialName("jpg")
    val jpg: Jpg
)

@Immutable
@Serializable
data class Jpg(
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("small_image_url")
    val smallImageUrl: String? = null,
    @SerialName("large_image_url")
    val largeImageUrl: String? = null,
)