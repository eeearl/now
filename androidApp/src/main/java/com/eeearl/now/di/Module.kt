package com.eeearl.now.di

import com.eeearl.now.viewmodel.TopViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val androidModule = module {
    viewModel { TopViewModel() }
}