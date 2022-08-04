package com.example.supertajnyprojekt.features.characters.details.presentation

import com.example.supertajnyprojekt.BR
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.BaseFragment
import com.example.supertajnyprojekt.databinding.FragmentCharacterDetailsBinding
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterDisplayable
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment :
    BaseFragment<CharacterDetailsViewModel, FragmentCharacterDetailsBinding>(
        BR.characterDetailsViewModel,
        R.layout.fragment_character_details
    ) {

    override val viewModel: CharacterDetailsViewModel by viewModel()

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

    override fun initObservers() {
        super.initObservers()
        getCharacter()
    }

    private fun getCharacter() {
        arguments?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let {
                viewModel.passCharacter(it)
            }
    }
}