package com.example.berlinclock_kata

import com.example.berlinclock_kata.domain.usecase.BerlinClockUseCase
import org.junit.Test
import org.junit.Assert.assertEquals
class BerlinClockUseCaseTest {

    lateinit var berlinClockUseCase: BerlinClockUseCase

    @Test
    fun `should return Y for even seconds`(){
         berlinClockUseCase = BerlinClockUseCase()
        var colour=berlinClockUseCase.getSecondLightColor(2)
        assertEquals("Y",colour)
    }
}