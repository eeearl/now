package com.eeearl.now

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import java.util.concurrent.TimeUnit

//actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(config) {
//    config()
//    engine {
//        config {
//            retryOnConnectionFailure(true)
//            connectTime(0, TimeUnit.SECONDS)
//        }
//    }
//}