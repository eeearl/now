package com.eeearl.now.repository

interface GreetingRepository {
    suspend fun greet(): String
}
class GreetingRepositoryImpl : GreetingRepository {
    override suspend fun greet(): String {
        return "Hello"
    }
}