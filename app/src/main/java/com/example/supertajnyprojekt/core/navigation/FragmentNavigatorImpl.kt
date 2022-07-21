package com.example.supertajnyprojekt.core.navigation

import androidx.annotation.IdRes
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.supertajnyprojekt.core.provider.ActivityProvider

class FragmentNavigatorImpl(
    private val activityProvider: ActivityProvider,
    @IdRes private val navHostFragmentRes: Int,
    @IdRes private val homeDestinationRes: Int,
    private val defaultNavOptions: NavOptions
) : FragmentNavigator {

    private fun getSupportFragmentManager() =
        (activityProvider.foregroundActivity as? FragmentActivity)?.supportFragmentManager

    private fun getNavController() = getSupportFragmentManager()
        ?.findFragmentById(navHostFragmentRes)
        ?.findNavController()

    override fun navigateTo(destinationId: Int, fragmentTransaction: FragmentTransaction?) {
        navigateTo<Unit>(destinationId, null, fragmentTransaction)
    }

    override fun <T> navigateTo(
        destinationId: Int,
        param: Pair<String, T>?,
        fragmentTransaction: FragmentTransaction?
    ) {
        val bundle = param?.let { bundleOf(it) }
        val navOptions = fragmentTransaction?.let {
            navOptions {
                anim { enter = it.enterAnim }
                anim { exit = it.exitAnim }
                anim { popEnter = it.popEnterAnim }
                anim { popExit = it.popExitAnim }
            }
        } ?: defaultNavOptions

        getNavController()?.navigate(destinationId, bundle, navOptions)
    }

    override fun goBack(destinationId: Int?, inclusive: Boolean) {
        if (destinationId == null) getNavController()?.popBackStack()
        else getNavController()?.popBackStack(destinationId, inclusive)
    }

    override fun clearHistory() {
        goBack(homeDestinationRes)
    }
}