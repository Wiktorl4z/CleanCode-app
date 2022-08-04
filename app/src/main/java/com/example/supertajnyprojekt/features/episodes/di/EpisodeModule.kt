package com.example.supertajnyprojekt.features.episodes.di

import com.example.supertajnyprojekt.features.episodes.data.repository.EpisodeRepositoryImpl
import com.example.supertajnyprojekt.features.episodes.details.presentation.EpisodeDetailsFragment
import com.example.supertajnyprojekt.features.episodes.details.presentation.EpisodeDetailsViewModel
import com.example.supertajnyprojekt.features.episodes.domain.EpisodeRepository
import com.example.supertajnyprojekt.features.episodes.domain.GetEpisodesUseCase
import com.example.supertajnyprojekt.features.episodes.navigation.EpisodeNavigator
import com.example.supertajnyprojekt.features.episodes.navigation.EpisodeNavigatorImpl
import com.example.supertajnyprojekt.features.episodes.presentation.EpisodeAdapter
import com.example.supertajnyprojekt.features.episodes.presentation.EpisodeFragment
import com.example.supertajnyprojekt.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    // domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get(), get(), get()) }
    factory { EpisodeFragment() }
    factory { EpisodeAdapter() }
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }
    viewModel { EpisodeDetailsViewModel() }
    factory { EpisodeDetailsFragment() }
}