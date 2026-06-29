package com.example.berlinclock_kata.domain.usecase

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.berlinclock_kata.core.TimeProvider
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.isActive
import javax.inject.Inject

class BerlinClockUseCase @Inject constructor(private val timeProvider: TimeProvider) {

    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke() = flow {
        while (currentCoroutineContext().isActive) {
            val time = timeProvider.now()
            emit(
                BerlinClockModel(
                    second = getSecondLightColor(time.second),
                    fiveHourRow = getFiveHourRow(time.hour),
                    oneHourRow = getOneHourRow(time.hour),
                    fiveMinRow = getFiveMinRow(time.minute),
                    oneMinRow = getOneMinRow(time.minute)
                )
            )
            delay(1000)
        }
    }

    private fun getSecondLightColor(seconds: Int): String {
        return if (seconds % 2 == 0) "Y" else "O"
    }

    private fun getFiveHourRow(hours: Int): String {
        val on = (hours / 5).toInt()
        return "R".repeat(on).padEnd(4, 'O')
    }

    private fun getOneHourRow(hours: Int): String {
        val on = (hours % 5).toInt()
        return "R".repeat(on).padEnd(4, 'O')
    }

    private fun getFiveMinRow(minutes: Int): String {
        val colors = CharArray(11) { 'O' }
        repeat(minutes / 5) {
            colors[it] = if ((it + 1) % 3 == 0) 'R' else 'Y'
        }
        return String(colors)
    }

    private fun getOneMinRow(minutes: Int): String {
        val on = (minutes % 5).toInt()
        return "Y".repeat(on).padEnd(4, 'O')
    }
}