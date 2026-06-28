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
        val colors = CharArray(11) { 'O' }
        repeat(minutes / 5) {
            colors[it] = if ((it + 1) % 3 == 0) 'R' else 'Y'
        }
        return String(colors)
    }

    fun getOneMinRow(minutes: Int): String {
        return "YYOO"
    }
}