package com.example.berlinclock_kata.domain.usecase

class BerlinClockUseCase {
    fun getSecondLightColor(seconds: Int): String {
        return if (seconds % 2 == 0) "Y" else "O"
    }

}