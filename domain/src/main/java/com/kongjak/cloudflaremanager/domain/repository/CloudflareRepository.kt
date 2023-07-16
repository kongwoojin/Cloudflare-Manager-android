package com.kongjak.cloudflaremanager.domain.repository

import com.kongjak.cloudflaremanager.domain.model.interfaces.Zones

interface CloudflareRepository {
    suspend fun getZones(token: String): Zones
}