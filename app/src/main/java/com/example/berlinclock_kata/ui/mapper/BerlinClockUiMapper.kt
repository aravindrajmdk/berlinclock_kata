package com.example.berlinclock_kata.ui.mapper

import androidx.compose.ui.graphics.Color
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import com.example.berlinclock_kata.ui.models.BerlinClockUiState

object BerlinClockUiMapper {
    fun map(model: BerlinClockModel): BerlinClockUiState{
        return BerlinClockUiState(second = Color.Yellow)
    }

    fun toColors(colour: String): List<Color>{
        return listOf(Color.Yellow)
    }
}