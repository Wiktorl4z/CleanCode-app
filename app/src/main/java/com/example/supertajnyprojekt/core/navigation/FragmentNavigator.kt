package com.example.supertajnyprojekt.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes

interface FragmentNavigator {
    fun navigateTo(
        @IdRes destinationId: Int,
        bundle: Bundle? = null,
        fragmentTransaction: FragmentTransaction? = null
    )

    fun goBack(@IdRes destinationId: Int? = null, inclusive: Boolean = false)
    fun clearHistory()
}