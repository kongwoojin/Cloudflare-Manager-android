package com.kongjak.cloudflaremanager.di

import com.kongjak.cloudflaremanager.data.datasource.local.UserLocalDataSource
import com.kongjak.cloudflaremanager.data.datasource.remote.CloudflareRemoteDataSource
import com.kongjak.cloudflaremanager.data.repository.CloudflareRepositoryImpl
import com.kongjak.cloudflaremanager.data.repository.UserRepositoryImpl
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import com.kongjak.cloudflaremanager.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideUserRepository(
        userLocalDataSource: UserLocalDataSource
    ): UserRepository {
        return UserRepositoryImpl(userLocalDataSource)
    }

    @Singleton
    @Provides
    fun provideCloudflareRepository(
        cloudflareRemoteDataSource: CloudflareRemoteDataSource
    ): CloudflareRepository {
        return CloudflareRepositoryImpl(cloudflareRemoteDataSource)
    }
}
