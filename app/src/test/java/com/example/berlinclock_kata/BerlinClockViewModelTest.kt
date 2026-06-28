package com.example.berlinclock_kata

import androidx.compose.ui.graphics.Color
import app.cash.turbine.test
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import com.example.berlinclock_kata.domain.usecase.BerlinClockUseCase
import com.example.berlinclock_kata.ui.viewmodels.BerlinClockViewModel
import io.mockk.every
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class BerlinClockViewModelTest {
    lateinit var viewModel: BerlinClockViewModel
    val useCase = mockk<BerlinClockUseCase>()

    @Test
    fun `ui state should expose mapped data from use case`() = runTest {
        every { useCase.invoke() } returns flowOf(
            BerlinClockModel(
                second = "Y",
                fiveHourRow = "RROO",
                oneHourRow = "RRRO",
                fiveMinRow = "YYROOOOOOOO",
                oneMinRow = "YYOO"
            )
        )
        viewModel = BerlinClockViewModel(useCase)

        viewModel.uiState.test {
            awaitItem()
            val state = awaitItem()

            assertEquals(Color.Yellow, state.second)

            cancelAndIgnoreRemainingEvents()
        }
    }
}