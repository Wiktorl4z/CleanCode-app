package com.example.supertajnyprojekt.features.characters.details.presentation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel>(R.layout.fragment_details) {

    override val viewModel: CharacterDetailsViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }
}