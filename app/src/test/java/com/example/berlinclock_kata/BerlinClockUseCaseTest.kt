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

    @Test
    fun `five hour row for 15 hours`() {
        val fiveHourRow = berlinClockUseCase.getFiveHourRow(15)
        assertEquals("RRRO", fiveHourRow)
    }

    @Test
    fun `five hour row for 3 hours`() {
        val fiveHourRow = berlinClockUseCase.getFiveHourRow(3)
        assertEquals("OOOO", fiveHourRow)
    }

    @Test
    fun `five hour row for 20 hours`() {
        val fiveHourRow = berlinClockUseCase.getFiveHourRow(20)
        assertEquals("RRRR", fiveHourRow)
    }

    @Test
    fun `one hour row for 4 hours`() {
        val oneHourRow = berlinClockUseCase.getOneHourRow(4)
        assertEquals("RRRR", oneHourRow)
    }
}