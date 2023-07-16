package com.kongjak.cloudflaremanager.domain.repository

import com.kongjak.cloudflaremanager.domain.model.interfaces.Zones
import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Verify

interface CloudflareRepository {
    suspend fun verifyToken(token: String): Verify
    suspend fun getZones(token: String, page: Int): Zones
}
