package com.example.berlinclock_kata.ui.mapper

import androidx.compose.ui.graphics.Color
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import com.example.berlinclock_kata.ui.models.BerlinClockUiState

object BerlinClockUiMapper {
    fun map(model: BerlinClockModel): BerlinClockUiState {
        return BerlinClockUiState(second = toColors(model.second).first())
    }

    fun toColors(colour: String): List<Color> {
        return colour.map {
            when (it) {
                'Y' -> Color.Yellow
                'R' -> Color.Red
                else -> Color.LightGray
            }
        }
    }
}