package com.eeearl.now.repository

import com.eeearl.now.data.AnimeResponse
import com.eeearl.now.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface RemoteRepository {
    suspend fun getTopList(): Flow<AnimeResponse>
}
class RemoteRepositoryImpl : RemoteRepository {
    override suspend fun getTopList(): Flow<AnimeResponse> = flow {
        val response = httpClient.get {
            url("https://api.jikan.moe/v4/top/anime")
        }.body<AnimeResponse>()
        emit(response)
    }
        //.flowOn(provideDispatcher())
}