package com.example.supertajnyprojekt.features.characters.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.supertajnyprojekt.core.base.BaseViewModel
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterDisplayable

class CharacterDetailsViewModel : BaseViewModel() {

    private val _character by lazy { MutableLiveData<CharacterDisplayable>() }
    val character: LiveData<CharacterDisplayable> by lazy { _character }

    fun passCharacter(characterDisplayable: CharacterDisplayable) {
        _character.value = characterDisplayable
    }
}