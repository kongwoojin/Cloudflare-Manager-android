package com.kongjak.cloudflaremanager.data.repository

import com.kongjak.cloudflaremanager.data.datasource.local.UserLocalDataSource
import com.kongjak.cloudflaremanager.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
): UserRepository {
    override suspend fun setUserEmail(email: String) {
        userLocalDataSource.setUserEmail(email)
    }

    override fun getUserEmail(): Flow<String> {
        return userLocalDataSource.getUserEmail()
    }

    override suspend fun setUserAPIKey(apiKey: String) {
        userLocalDataSource.setUserAPIKey(apiKey)
    }

    override fun getUserAPIKey(): Flow<String> {
        return userLocalDataSource.getUserAPIKey()
    }
}