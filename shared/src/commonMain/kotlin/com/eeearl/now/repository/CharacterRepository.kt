package com.eeearl.now.repository

import com.eeearl.now.data.CharacterResponse
import com.eeearl.now.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.util.AttributeKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface CharacterRepository {
    suspend fun getTopCharacterList(
        page: Int,
        limit: Int,
    ): Flow<CharacterResponse>
}
class CharacterRepositoryImpl : CharacterRepository {
    override suspend fun getTopCharacterList(
        page: Int,
        limit: Int,
    ): Flow<CharacterResponse> = flow {
        val response = httpClient.get {
            url("https://api.jikan.moe/v4/top/characters")
            attributes.put(AttributeKey("page"), page)
            attributes.put(AttributeKey("limit"), limit)
        }.body<CharacterResponse>()
        emit(response)
    }
}