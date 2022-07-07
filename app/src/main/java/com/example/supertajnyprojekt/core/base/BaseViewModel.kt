package com.example.supertajnyprojekt.core.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _message by lazy { LiveEvent<String>() }

    val message: LiveData<String> = _message

    private val _uiState by lazy { MutableLiveData<UiState>() }

    val uiState: LiveData<UiState> = _uiState

    protected fun setIdleState() {
        _uiState.value = UiState.Idle
    }

    protected fun setPendingState() {
        _uiState.value = UiState.Pending
    }

    protected fun handleFailure(throwable: Throwable) {
        throwable.message?.let { showMessage(it) }
    }

    private fun showMessage(message: String) {
        _message.value = message
    }
}