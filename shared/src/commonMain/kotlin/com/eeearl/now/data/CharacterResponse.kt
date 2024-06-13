package com.eeearl.now.data

import androidx.compose.runtime.Immutable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class CharacterResponse(
    @SerialName("data")
    val list: List<Character>,
    @SerialName("pagination")
    val pagination: Pagination?
)