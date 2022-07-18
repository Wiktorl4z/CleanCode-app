package com.example.supertajnyprojekt.features.locations.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.supertajnyprojekt.core.base.UiState
import com.example.supertajnyprojekt.core.exception.ErrorMapper
import com.example.supertajnyprojekt.features.locations.domain.GetLocationUseCase
import com.example.supertajnyprojekt.features.locations.domain.model.Location
import com.example.supertajnyprojekt.mock.mock
import com.example.supertajnyprojekt.utils.ViewModelTest
import com.example.supertajnyprojekt.utils.getOrAwaitValue
import com.example.supertajnyprojekt.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN location live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetLocationUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN location live data is observed THEN invoke use case to get locations`() {
        //given
        val useCase = mockk<GetLocationUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationViewModel(useCase, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN location live data is observed THEN set idle state AND set result in live data`() {
        //given
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val errorMapper = mockk<ErrorMapper>(relaxed = true)

        val useCase = mockk<GetLocationUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val viewModel = LocationViewModel(useCase, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.name shouldBe location.name
            locationDisplayable.type shouldBe location.type
            locationDisplayable.dimension shouldBe location.dimension
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN location live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val useCase = mockk<GetLocationUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }

        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = LocationViewModel(useCase, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}