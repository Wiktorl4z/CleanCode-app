package com.example.supertajnyprojekt.features.episodes.details.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.supertajnyprojekt.core.base.BaseViewModel
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeDetailsViewModel : BaseViewModel() {

    private val _episode by lazy { MutableLiveData<EpisodeDisplayable>() }
    val episode: LiveData<EpisodeDisplayable> by lazy { _episode }

    fun passEpisode(episodeDisplayable: EpisodeDisplayable) {
        _episode.value = episodeDisplayable
    }
}