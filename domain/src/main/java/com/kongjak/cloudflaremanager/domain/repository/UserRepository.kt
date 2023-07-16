package com.kongjak.cloudflaremanager.domain.repository

import kotlinx.coroutines.flow.Flow


interface UserRepository {
    suspend fun setUserToken(token: String)
    fun getUserToken(): String?
}