package com.example.supertajnyprojekt.features.episodes.presentation

import androidx.lifecycle.*
import com.example.supertajnyprojekt.core.base.UiState
import com.example.supertajnyprojekt.features.episodes.domain.GetEpisodesUseCase
import com.example.supertajnyprojekt.features.episodes.domain.model.Episode
import com.example.supertajnyprojekt.features.episodes.presentation.model.EpisodeDisplayable
import com.hadilq.liveevent.LiveEvent

class EpisodeViewModel(private val getEpisodesUseCase: GetEpisodesUseCase) : ViewModel() {

    private val _message by lazy { LiveEvent<String>() }

    val message: LiveData<String> = _message

    private val _uiState by lazy { MutableLiveData<UiState>() }

    val uiState: LiveData<UiState> = _uiState

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> = _episodes.map { episodes ->
        episodes.map { EpisodeDisplayable(it) }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodes ->
                episodeLiveData.value = episodes
            }
            result.onFailure { throwable ->
                throwable.message?.let {
                    showMessage(it)
                }
            }
        }
    }

    private fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    private fun setPendingState() {
        _uiState.value = UiState.Pending
    }

    private fun showMessage(message: String) {
        _message.value = message
    }
}