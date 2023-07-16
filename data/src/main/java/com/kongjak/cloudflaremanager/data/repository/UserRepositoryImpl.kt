package com.kongjak.cloudflaremanager.data.repository

import com.kongjak.cloudflaremanager.data.datasource.local.UserLocalDataSource
import com.kongjak.cloudflaremanager.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userLocalDataSource: UserLocalDataSource
): UserRepository {
    override suspend fun setUserToken(token: String) {
        userLocalDataSource.setUserToken(token)
    }

    override fun getUserToken(): Flow<String> {
        return userLocalDataSource.getUserToken()
    }
}