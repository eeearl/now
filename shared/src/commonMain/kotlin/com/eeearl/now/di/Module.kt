package com.eeearl.now.di

import com.eeearl.now.repository.AnimeRepository
import com.eeearl.now.repository.AnimeRepositoryImpl
import com.eeearl.now.repository.CharacterRepository
import com.eeearl.now.repository.CharacterRepositoryImpl
import com.eeearl.now.repository.GreetingRepository
import com.eeearl.now.repository.GreetingRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun appModule() = module {
    singleOf(::AnimeRepositoryImpl) { bind<AnimeRepository>() }
    singleOf(::GreetingRepositoryImpl) { bind<GreetingRepository>() }
    singleOf(::CharacterRepositoryImpl) { bind<CharacterRepository>() }
}