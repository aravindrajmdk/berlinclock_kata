package com.example.berlinclock_kata.ui.models

import androidx.compose.ui.graphics.Color

data class BerlinClockUi(
    val second: Color,
    val fiveHourRow: List<Color>,
    val oneHourRow: List<Color>,
    val fiveMinRow: List<Color>,
    val oneMinRow: List<Color>
)
