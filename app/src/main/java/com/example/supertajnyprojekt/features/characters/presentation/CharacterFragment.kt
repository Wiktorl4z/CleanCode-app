package com.example.supertajnyprojekt.features.characters.presentation

import androidx.fragment.app.viewModels
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment


class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModels()

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
        viewModel.characters.observe(this) {
            // code to display episodes
        }
    }
}