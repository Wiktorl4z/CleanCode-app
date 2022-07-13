package com.example.supertajnyprojekt.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}