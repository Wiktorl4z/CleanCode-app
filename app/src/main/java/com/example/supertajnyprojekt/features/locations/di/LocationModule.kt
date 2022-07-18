package com.example.supertajnyprojekt.features.locations.di

import com.example.supertajnyprojekt.features.locations.data.repository.LocationRepositoryImpl
import com.example.supertajnyprojekt.features.locations.domain.GetLocationUseCase
import com.example.supertajnyprojekt.features.locations.domain.LocationRepository
import com.example.supertajnyprojekt.features.locations.presentation.LocationFragment
import com.example.supertajnyprojekt.features.locations.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetLocationUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get(), get(), get()) }
    factory { LocationFragment() }
}