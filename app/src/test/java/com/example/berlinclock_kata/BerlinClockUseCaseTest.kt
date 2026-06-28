package com.example.berlinclock_kata

import com.example.berlinclock_kata.domain.usecase.BerlinClockUseCase
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Before

class BerlinClockUseCaseTest {

    lateinit var berlinClockUseCase: BerlinClockUseCase

    @Before
    fun setUp(){
        berlinClockUseCase = BerlinClockUseCase()
    }

    @Test
    fun `should return Y for even seconds`(){
        var colour=berlinClockUseCase.getSecondLightColor(2)
        assertEquals("Y",colour)
    }

    @Test
    fun `should return O for odd seconds`() {
        var colour = berlinClockUseCase.getSecondLightColor(1)
        assertEquals("O", colour)
    }
}