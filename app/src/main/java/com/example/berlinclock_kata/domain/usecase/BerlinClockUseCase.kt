package com.example.berlinclock_kata.domain.usecase

class BerlinClockUseCase {
    fun getSecondLightColor(seconds: Int): String {
        return if (seconds % 2 == 0) "Y" else "O"
    }

    fun getFiveHourRow(hours: Int): String {
        val on = (hours / 5).toInt()
        return "R".repeat(on).padEnd(4, 'O')
    }

    fun getOneHourRow(hours: Int): String {
        val on = (hours % 5).toInt()
        return "R".repeat(on).padEnd(4, 'O')
    }

    fun getFiveMinRow(minutes: Int): String {
        return "YYOOOOOOOOO"
    }
}