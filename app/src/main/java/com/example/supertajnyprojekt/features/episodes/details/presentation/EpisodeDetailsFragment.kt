package com.example.supertajnyprojekt.features.episodes.details.presentation

import com.example.supertajnyprojekt.BR
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import com.example.supertajnyprojekt.databinding.FragmentEpisodeDetailsBinding
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeDetailsFragment :
    BaseFragment<EpisodeDetailsViewModel, FragmentEpisodeDetailsBinding>(
        BR.episodeDetailsViewModel,
        R.layout.fragment_episode_details
    ) {

    override val viewModel: EpisodeDetailsViewModel by viewModel()

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        getEpisode()
    }

    private fun getEpisode() {
        arguments?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let {
                viewModel.passEpisode(it)
            }
    }
}