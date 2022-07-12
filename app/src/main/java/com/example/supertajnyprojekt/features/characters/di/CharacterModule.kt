package com.example.supertajnyprojekt.features.characters.di

import com.example.supertajnyprojekt.features.characters.data.repository.CharacterRepositoryImpl
import com.example.supertajnyprojekt.features.characters.domain.CharacterRepository
import com.example.supertajnyprojekt.features.characters.domain.GetCharacterUseCase
import com.example.supertajnyprojekt.features.characters.presentation.CharacterFragment
import com.example.supertajnyprojekt.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get()) }

    // domain
    factory { GetCharacterUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get()) }
    factory { CharacterFragment() }
}