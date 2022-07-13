package com.example.supertajnyprojekt.features.locations.presentation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

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
        viewModel.message.observe(this) {

        }
    }
}