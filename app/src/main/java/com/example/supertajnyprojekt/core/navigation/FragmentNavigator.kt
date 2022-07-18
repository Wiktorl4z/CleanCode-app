package com.example.supertajnyprojekt.core.navigation

import androidx.annotation.IdRes

interface FragmentNavigator {

    fun navigateTo(
        @IdRes destinationId: Int,
        fragmentTransaction: FragmentTransaction? = null
    )

    fun <T> navigateTo(
        @IdRes destinationId: Int,
        param: Pair<String, T>? = null,
        fragmentTransaction: FragmentTransaction? = null
    )

    fun goBack(@IdRes destinationId: Int? = null, inclusive: Boolean = false)
    fun clearHistory()
}