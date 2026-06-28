package com.example.berlinclock_kata.di

import com.example.berlinclock_kata.core.SystemTimeProvider
import com.example.berlinclock_kata.core.TimeProvider
import com.example.berlinclock_kata.domain.usecase.BerlinClockUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindTimeProvider(
        impl: SystemTimeProvider
    ): TimeProvider

}