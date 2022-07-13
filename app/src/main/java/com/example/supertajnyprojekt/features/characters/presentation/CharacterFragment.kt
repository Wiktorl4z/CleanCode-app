package com.example.supertajnyprojekt.features.characters.presentation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

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
        viewModel.message.observe(this) {

        }
    }
}