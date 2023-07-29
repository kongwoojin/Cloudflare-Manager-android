package com.kongjak.cloudflaremanager.domain.repository

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.ZoneList
import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Verify
import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.detail.ZoneDetail

interface CloudflareRepository {
    suspend fun verifyToken(token: String): Verify
    suspend fun getZones(token: String, page: Int): ZoneList
    suspend fun getZoneDetail(token: String, id: String): ZoneDetail
}
