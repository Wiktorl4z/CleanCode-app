package com.example.supertajnyprojekt.features.episodes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.base.UiState


class EpisodeFragment : Fragment() {

    private val viewModel: EpisodeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeEpisodes()
        observerUiState()
        observerMessage()
    }

    private fun observerMessage() {
        viewModel.message.observe(this) {
            showToast(it)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun observerUiState() {
        viewModel.uiState.observe(this) {
            when (it) {
                UiState.Idle -> onIdleState()
                UiState.Pending -> onPendingState()
            }
        }
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            // code to display episodes
        }
    }

    private fun onIdleState() {
        // handle idle state
    }

    private fun onPendingState() {
        // handle pending state
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_episode, container, false)
    }

}