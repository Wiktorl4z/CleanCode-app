package com.example.supertajnyprojekt.features.locations.navigation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.navigation.FragmentNavigator
import com.example.supertajnyprojekt.features.locations.details.presentation.LocationDetailsFragment
import com.example.supertajnyprojekt.features.locations.presentation.model.LocationDisplayable

class LocationNavigatorImpl(
    private val fragmentNavigator: FragmentNavigator
) : LocationNavigator {
    override fun openLocationDetailsScreen(locationDisplayable: LocationDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_location_screen_to_location_details_screen,
            LocationDetailsFragment.LOCATION_DETAILS_KEY to locationDisplayable
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}