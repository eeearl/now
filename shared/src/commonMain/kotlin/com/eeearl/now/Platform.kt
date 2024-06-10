package com.eeearl.now

interface Platform {
    val name: String
    fun getPlatformName(): String
}

expect fun getPlatform(): Platform

//expect class PlatformImp: Platform {
//    override val name: String
//    override fun getPlatformName(): String
//}