package com.example.supertajnyprojekt.features.episodes.details.presentation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()

    companion object{
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}