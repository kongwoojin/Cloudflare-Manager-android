package com.kongjak.cloudflaremanager.data.repository

import com.kongjak.cloudflaremanager.data.datasource.remote.CloudflareRemoteDataSource
import com.kongjak.cloudflaremanager.domain.model.interfaces.Zones
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import javax.inject.Inject

class CloudflareRepositoryImpl @Inject constructor(private val cloudflareRemoteDataSource: CloudflareRemoteDataSource): CloudflareRepository {
    override suspend fun getZones(token: String): Zones {
        return cloudflareRemoteDataSource.getZones(token)
    }
}