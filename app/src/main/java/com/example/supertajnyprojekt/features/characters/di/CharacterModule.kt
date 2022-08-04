package com.example.supertajnyprojekt.features.characters.di

import com.example.supertajnyprojekt.features.characters.data.repository.CharacterRepositoryImpl
import com.example.supertajnyprojekt.features.characters.details.presentation.CharacterDetailsFragment
import com.example.supertajnyprojekt.features.characters.details.presentation.CharacterDetailsViewModel
import com.example.supertajnyprojekt.features.characters.domain.CharacterRepository
import com.example.supertajnyprojekt.features.characters.domain.GetCharacterUseCase
import com.example.supertajnyprojekt.features.characters.navigation.CharacterNavigator
import com.example.supertajnyprojekt.features.characters.navigation.CharacterNavigatorImpl
import com.example.supertajnyprojekt.features.characters.presentation.CharacterAdapter
import com.example.supertajnyprojekt.features.characters.presentation.CharacterFragment
import com.example.supertajnyprojekt.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetCharacterUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get(), get(), get()) }
    factory { CharacterFragment() }
    factory { CharacterAdapter() }
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }
    viewModel { CharacterDetailsViewModel() }
    factory { CharacterDetailsFragment() }
}