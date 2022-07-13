package com.example.supertajnyprojekt.features.episodes.presentation

import androidx.fragment.app.viewModels
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment


class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModels()

    override fun initViews() {
        super.initViews()
        // initialize all view-related classes
    }

    override fun initObservers() {
        super.initObservers()
        subscribeToObservers()
    }

    override fun onIdleState() {
        super.onIdleState()
        // handle idle state
    }

    override fun onPendingState() {
        super.onPendingState()
        // handle pending state
    }

    private fun subscribeToObservers() {
        viewModel.episodes.observe(this) {
            // code to display episodes
        }
    }
}