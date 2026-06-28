package com.example.berlinclock_kata.ui.viewmodels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.berlinclock_kata.domain.models.BerlinClockModel
import com.example.berlinclock_kata.domain.usecase.BerlinClockUseCase
import com.example.berlinclock_kata.ui.mapper.BerlinClockUiMapper
import com.example.berlinclock_kata.ui.models.BerlinClockUiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class BerlinClockViewModel(useCase: BerlinClockUseCase): ViewModel() {
    @RequiresApi(Build.VERSION_CODES.O)
    val uiState: StateFlow<BerlinClockUiState> = useCase().map {
        BerlinClockUiMapper.map(it)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        BerlinClockUiMapper.map(BerlinClockModel(
            second = "O",
            fiveHourRow = "OOOO",
            oneHourRow = "OOOO",
            fiveMinRow = "OOOOOOOOOOO",
            oneMinRow = "OOOO"
        ))
    )
}