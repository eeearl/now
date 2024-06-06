package com.eeearl.now

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class Greeting {
    private val client = HttpClient()

    suspend fun greet(): String {
        return client.get("https://ktor.io/docs/")
            .bodyAsText()
    }
}