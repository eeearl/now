package com.eeearl.now

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.http.ContentType.Application.Json
import kotlinx.serialization.json.Json

//expect fun httpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient
//
//val networkClient: HttpClient = httpClient {
//    install(ContentNegotiation) {
//        json(
//            Json {
//                prettyPrint = true
//                isLenient = true
//                ignoreUnknownKeys = true
//            }
//        )
//    }
//}