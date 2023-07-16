package com.kongjak.cloudflaremanager.data.repository

import com.kongjak.cloudflaremanager.data.datasource.remote.CloudflareRemoteDataSource
import com.kongjak.cloudflaremanager.domain.model.interfaces.Zones
import com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify.Verify
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import javax.inject.Inject

class CloudflareRepositoryImpl @Inject constructor(private val cloudflareRemoteDataSource: CloudflareRemoteDataSource) : CloudflareRepository {
    override suspend fun verifyToken(token: String): Verify {
        return cloudflareRemoteDataSource.verifyToken(token)
    }

    override suspend fun getZones(token: String, page: Int): Zones {
        return cloudflareRemoteDataSource.getZones(token, page)
    }
}
