package com.example.supertajnyprojekt.features.locations.navigation

import com.example.supertajnyprojekt.R
import com.example.supertajnyprojekt.core.navigation.FragmentNavigator
import com.example.supertajnyprojekt.features.locations.presentation.model.LocationDisplayable
import com.example.supertajnyprojekt.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationNavigatorImplTest {

    @Test
    fun `WHEN openLocationDetailsScreen is called THAN invoke navigateTo method with appropriate action and location model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val location = LocationDisplayable.mock()
        val slot = slot<Pair<String, LocationDisplayable>>()

        //when
        locationNavigator.openLocationDetailsScreen(location)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_location_screen_to_location_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe location
    }

    @Test
    fun `WHEN openLocationDetailsScreen is called THAN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)

        //when
        locationNavigator.goBack()

        //then
        verify {
            fragmentNavigator.goBack()
        }
    }
}