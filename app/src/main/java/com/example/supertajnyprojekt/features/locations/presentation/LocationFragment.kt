package com.example.supertajnyprojekt.features.locations.presentation

import androidx.fragment.app.viewModels
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment


class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModels()

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
        viewModel.locations.observe(this) {
            // code to display episodes
        }
    }
}