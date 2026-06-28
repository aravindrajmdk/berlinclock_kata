package com.example.berlinclock_kata

import com.example.berlinclock_kata.domain.usecase.BerlinClockUseCase
import org.junit.Test
import org.junit.Assert.assertEquals
class BerlinClockUseCaseTest {

    @Test
    fun `should return Y for even seconds`(){
        val berlinClockUseCase = BerlinClockUseCase()
        var colour=berlinClockUseCase.getSecondLightColor(2)
        assertEquals("Y",colour)
    }
}