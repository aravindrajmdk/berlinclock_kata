package com.example.berlinclock_kata.domain.usecase

import com.example.berlinclock_kata.core.FakeTimeProvider
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalTime

class BerlinClockUseCaseTest {

    lateinit var berlinClockUseCase: BerlinClockUseCase

    @Test
    fun `should return Y for even seconds`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(13, 17, 2)))
        var colour = berlinClockUseCase().first().second
        Assertions.assertEquals("Y", colour)
    }

    @Test
    fun `should return O for odd seconds`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(13, 17, 1)))
        var colour = berlinClockUseCase().first().second
        Assertions.assertEquals("O", colour)
    }

    @Test
    fun `five hour row for 15 hours`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(15, 15, 1)))
        var fiveHourRow = berlinClockUseCase().first().fiveHourRow
        Assertions.assertEquals("RRRO", fiveHourRow)
    }

    @Test
    fun `five hour row for 3 hours`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(3, 0, 1)))
        var fiveHourRow = berlinClockUseCase().first().fiveHourRow
        Assertions.assertEquals("OOOO", fiveHourRow)
    }

    @Test
    fun `five hour row for 20 hours`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(20, 3, 1)))
        var fiveHourRow = berlinClockUseCase().first().fiveHourRow
        Assertions.assertEquals("RRRR", fiveHourRow)
    }

    @Test
    fun `one hour row for 4 hours`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(4, 3, 1)))
        var oneHourRow = berlinClockUseCase().first().oneHourRow
        Assertions.assertEquals("RRRR", oneHourRow)
    }

    @Test
    fun `one hour row for 2 hours`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(2, 3, 1)))
        var oneHourRow = berlinClockUseCase().first().oneHourRow
        Assertions.assertEquals("RROO", oneHourRow)
    }

    @Test
    fun `five min row for 10 min`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(13, 10, 1)))
        var fiveMinRow = berlinClockUseCase().first().fiveMinRow
        Assertions.assertEquals("YYOOOOOOOOO", fiveMinRow)
    }

    @Test
    fun `five min row for 15 min`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(13, 15, 1)))
        var fiveMinRow = berlinClockUseCase().first().fiveMinRow
        Assertions.assertEquals("YYROOOOOOOO", fiveMinRow)
    }

    @Test
    fun `one min row for 2 min`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(13, 2, 1)))
        var oneMinRow = berlinClockUseCase().first().oneMinRow
        Assertions.assertEquals("YYOO", oneMinRow)
    }

    @Test
    fun `one min row for 1 min`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(13, 1, 1)))
        var oneMinRow = berlinClockUseCase().first().oneMinRow
        Assertions.assertEquals("YOOO", oneMinRow)
    }

    @Test
    fun `validate berlin clock invoke`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(13, 17, 8)))
        val result = berlinClockUseCase().first() //13,17,8
        Assertions.assertEquals(
            BerlinClockModel(
                second = "Y",
                fiveHourRow = "RROO",
                oneHourRow = "RRRO",
                fiveMinRow = "YYROOOOOOOO",
                oneMinRow = "YYOO"
            ), result
        )
    }

    @Test
    fun `validate multiple emisions`() = runTest {
        berlinClockUseCase = BerlinClockUseCase(FakeTimeProvider(LocalTime.of(13, 17, 8)))
        val result = berlinClockUseCase().take(2).toList()
        Assertions.assertEquals(2, result.size)
    }
}