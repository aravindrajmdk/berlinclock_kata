package com.example.berlinclock_kata.ui.mapper

import androidx.compose.ui.graphics.Color
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import com.example.berlinclock_kata.ui.models.BerlinClockUiState

class BerlinClockUiMapper {
    fun map(model: BerlinClockModel): BerlinClockUiState{
        return BerlinClockUiState(second = Color.Yellow)
    }
}