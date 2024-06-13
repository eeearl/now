package com.eeearl.now.repository

import com.eeearl.now.data.AnimeResponse
import com.eeearl.now.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.util.AttributeKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface AnimeRepository {
    suspend fun getTopAnimeList(page: Int): Flow<AnimeResponse>
}
class AnimeRepositoryImpl : AnimeRepository {
    override suspend fun getTopAnimeList(
        page: Int
    ): Flow<AnimeResponse> = flow {
        val response = httpClient.get {
            url("https://api.jikan.moe/v4/top/anime")
            attributes.put(AttributeKey("page"), page)
        }.body<AnimeResponse>()
        emit(response)
    }
}