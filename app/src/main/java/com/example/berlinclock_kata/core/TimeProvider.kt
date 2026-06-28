package com.example.berlinclock_kata.core

import java.time.LocalTime

interface TimeProvider {
    fun now(): LocalTime
}