package com.eeearl.now.repository

import com.eeearl.now.data.AnimeResponse
import com.eeearl.now.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url

interface RemoteRepository {
    suspend fun getTopList(): AnimeResponse
}
class RemoteRepositoryImpl : RemoteRepository {
    override suspend fun getTopList(): AnimeResponse = httpClient.get {
        url("https://api.jikan.moe/v4/top/anime")
    }.body()
}