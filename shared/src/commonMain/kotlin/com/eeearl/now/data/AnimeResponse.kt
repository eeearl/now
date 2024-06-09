package com.eeearl.now.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeResponse(
    @SerialName("data")
    val `data`: List<Anime> = listOf(),
//    @SerialName("links")
//    val links: Links = Links(),
//    @SerialName("meta")
//    val meta: Meta = Meta(),
//    @SerialName("pagination")
//    val pagination: Pagination = Pagination()
)