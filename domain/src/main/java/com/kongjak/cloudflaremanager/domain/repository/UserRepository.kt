package com.kongjak.cloudflaremanager.domain.repository

import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun setUserEmail(email: String)
    fun getUserEmail(): Flow<String>
    suspend fun setUserAPIKey(apiKey: String)
    fun getUserAPIKey(): Flow<String>
}