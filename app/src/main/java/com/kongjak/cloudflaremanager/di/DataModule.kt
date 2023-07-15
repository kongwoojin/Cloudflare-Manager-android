package com.kongjak.cloudflaremanager.di

import android.content.Context
import com.kongjak.cloudflaremanager.data.datasource.local.UserLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideUserLocalDataSource(
        @ApplicationContext context: Context
    ): UserLocalDataSource {
        return UserLocalDataSource(context)
    }
}