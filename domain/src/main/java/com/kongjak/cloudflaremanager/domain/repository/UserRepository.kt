package com.kongjak.cloudflaremanager.domain.repository

interface UserRepository {
    suspend fun setUserToken(token: String)
    fun getUserToken(): String?
}
