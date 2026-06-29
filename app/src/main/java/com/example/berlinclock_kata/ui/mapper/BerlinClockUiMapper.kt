package com.example.berlinclock_kata.ui.mapper

import androidx.compose.ui.graphics.Color
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import com.example.berlinclock_kata.ui.models.BerlinClockUi

object BerlinClockUiMapper {
    fun map(model: BerlinClockModel): BerlinClockUi {
        return BerlinClockUi(
            second = toColors(model.second).first(),
            fiveHourRow = toColors(model.fiveHourRow),
            oneHourRow = toColors(model.oneHourRow),
            fiveMinRow = toColors(model.fiveMinRow),
            oneMinRow = toColors(model.oneMinRow)
        )
    }

    fun toColors(colour: String): List<Color> {
        return colour.map {
            when (it) {
                'Y' -> Color.Yellow
                'R' -> Color.Red
                else -> Color.DarkGray
            }
        }
    }
}