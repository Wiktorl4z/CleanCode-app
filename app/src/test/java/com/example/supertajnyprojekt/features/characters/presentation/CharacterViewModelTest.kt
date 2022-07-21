package com.example.supertajnyprojekt.features.characters.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.supertajnyprojekt.core.base.UiState
import com.example.supertajnyprojekt.core.exception.ErrorMapper
import com.example.supertajnyprojekt.features.characters.domain.GetCharacterUseCase
import com.example.supertajnyprojekt.features.characters.domain.model.Character
import com.example.supertajnyprojekt.features.characters.navigation.CharacterNavigator
import com.example.supertajnyprojekt.features.characters.presentation.model.CharacterDisplayable
import com.example.supertajnyprojekt.mock.mock
import com.example.supertajnyprojekt.utils.ViewModelTest
import com.example.supertajnyprojekt.utils.getOrAwaitValue
import com.example.supertajnyprojekt.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character is clicked THAN open character details screen`() {
        //given
        val useCase = mockk<GetCharacterUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)
        val characterDisplayable = CharacterDisplayable.mock()

        //when
        viewModel.onCharacterClick(characterDisplayable)

        //then
        verify { characterNavigator.openCharacterDetailsScreen(characterDisplayable) }
    }

    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharacterUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get characters`() {
        //given
        val useCase = mockk<GetCharacterUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN character live data is observed THEN set idle state AND set result in live data`() {
        //given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())

        val useCase = mockk<GetCharacterUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)

        // when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.gender shouldBe character.gender
            characterDisplayable.image shouldBe character.image
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN character live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetCharacterUseCase> {
            every { this@mockk(Unit, any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }

        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}