package com.eeearl.now

class AndroidPlatform: Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override fun getPlatformName(): String = name
}

actual fun getPlatform(): Platform = AndroidPlatform()
