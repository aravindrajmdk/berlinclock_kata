package com.example.berlinclock_kata

import com.example.berlinclock_kata.core.TimeProvider
import java.time.LocalTime

class FakeTimeProvider(
    private val time: LocalTime
) : TimeProvider {

    override fun now(): LocalTime = time
}