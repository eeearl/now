package com.eeearl.now.di

import com.eeearl.now.repository.GreetingRepository
import com.eeearl.now.repository.GreetingRepositoryImpl
import com.eeearl.now.repository.RemoteRepository
import com.eeearl.now.repository.RemoteRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun appModule() = module {
    singleOf(::RemoteRepositoryImpl) { bind<RemoteRepository>() }
    singleOf(::GreetingRepositoryImpl) { bind<GreetingRepository>() }
}