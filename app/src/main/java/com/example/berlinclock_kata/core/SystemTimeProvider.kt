package com.example.berlinclock_kata.core

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime
import javax.inject.Inject

class SystemTimeProvider @Inject constructor() : TimeProvider {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun now(): LocalTime {
        return LocalTime.now()
    }
}
