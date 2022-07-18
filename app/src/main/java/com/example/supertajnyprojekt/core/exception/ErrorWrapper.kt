package com.example.supertajnyprojekt.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}