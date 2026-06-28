package com.example.berlinclock_kata

import android.provider.CalendarContract
import androidx.compose.ui.graphics.Color
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import com.example.berlinclock_kata.ui.mapper.BerlinClockUiMapper
import org.junit.Test

class BerlinClockUiMapperTest {

    @Test
    fun `should map BerlinClockModel to BerlinClockUiState`() {
        val berlinClockModel = BerlinClockModel(
            second = "Y",
            fiveHourRow = "RROO",
            oneHourRow = "RRRO",
            fiveMinRow = "YYROOOOOOOO")
        val berlinClockUiState = BerlinClockUiMapper.map(berlinClockModel)
        assert(berlinClockUiState.second == Color.Yellow)
    }

    @Test
    fun `toColors should return color code`(){
       val color= BerlinClockUiMapper.toColors("Y")
        assert(color.first() == Color.Yellow)
    }

    @Test
    fun `toColors should return color RED`(){
        val color= BerlinClockUiMapper.toColors("R")
        assert(color.first() == Color.Red)
    }
}