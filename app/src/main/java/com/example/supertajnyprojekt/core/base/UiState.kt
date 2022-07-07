package com.example.supertajnyprojekt.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}