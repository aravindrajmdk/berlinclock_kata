package com.example.berlinclock_kata.ui.mapper

import androidx.compose.ui.graphics.Color
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import org.junit.jupiter.api.Test

class BerlinClockUiMapperTest {
    val berlinClockMapper = BerlinClockUiMapper()

    @Test
    fun `should map BerlinClockModel to BerlinClockUiState`() {
        val berlinClockModel = BerlinClockModel(
            second = "Y",
            fiveHourRow = "RROO",
            oneHourRow = "RRRO",
            fiveMinRow = "YYROOOOOOOO",
            oneMinRow = "YYOO"
        )
        val result =berlinClockMapper.map(berlinClockModel)
        assert(result.second == Color.Companion.Yellow)
    }

    @Test
    fun `should map BerlinClockModel to BerlinClockUiState map all fields`(){
        val berlinClockModel = BerlinClockModel(
            second = "Y",
            fiveHourRow = "RROO",
            oneHourRow = "RRRO",
            fiveMinRow = "YYROOOOOOOO",
            oneMinRow = "YYOO"
        )
        val berlinClockUiState = berlinClockMapper.map(berlinClockModel)
        assert(berlinClockUiState.second == Color.Companion.Yellow)
        assert(berlinClockUiState.fiveHourRow == listOf(
            Color.Companion.Red,
            Color.Companion.Red,
            Color.Companion.DarkGray,
            Color.Companion.DarkGray))
    }
}