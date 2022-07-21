package com.example.supertajnyprojekt.features.episodes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.supertajnyprojekt.core.base.BaseViewModel
import com.example.supertajnyprojekt.core.exception.ErrorMapper
import com.example.supertajnyprojekt.features.episodes.domain.GetEpisodesUseCase
import com.example.supertajnyprojekt.features.episodes.domain.model.Episode
import com.example.supertajnyprojekt.features.episodes.navigation.EpisodeNavigator
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable

class EpisodeViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase,
    private val episodeNavigator: EpisodeNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodeLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onEpisodeClick(episode: EpisodeDisplayable) {
        episodeNavigator.openEpisodeDetailsScreen(episode)
    }
}