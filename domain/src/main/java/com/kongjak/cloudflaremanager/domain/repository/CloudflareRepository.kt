package com.kongjak.cloudflaremanager.domain.repository

interface CloudflareRepository {
    suspend fun getZones(email: String, apiKey: String)
}