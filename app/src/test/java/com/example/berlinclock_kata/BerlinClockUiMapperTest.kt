package com.example.berlinclock_kata

import androidx.compose.ui.graphics.Color
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import com.example.berlinclock_kata.ui.mapper.BerlinClockUiMapper
import org.junit.Test

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
        assert(result.second == Color.Yellow)
    }

    @Test
    fun `toColors should return color code`(){
       val color= berlinClockMapper.toColors("Y")
        assert(color.first() == Color.Yellow)
    }

    @Test
    fun `toColors should return color RED`(){
        val color= berlinClockMapper.toColors("R")
        assert(color.first() == Color.Red)
    }

    @Test
    fun `toColors should return color multiple colors`(){
        val color= berlinClockMapper.toColors("RY")
        assert(color.first() == Color.Red)
        assert(color.get(1) == Color.Yellow)
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
        assert(berlinClockUiState.second == Color.Yellow)
        assert(berlinClockUiState.fiveHourRow == listOf(Color.Red,Color.Red,Color.DarkGray,Color.DarkGray))
    }
}