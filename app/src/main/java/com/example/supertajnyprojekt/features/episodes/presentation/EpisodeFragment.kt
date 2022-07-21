package com.example.supertajnyprojekt.features.episodes.presentation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodeViewModel by viewModel()

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