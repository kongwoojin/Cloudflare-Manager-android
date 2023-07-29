package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.ZoneList
import com.kongjak.cloudflaremanager.domain.repository.CloudflareRepository
import javax.inject.Inject

class GetZonesUseCase @Inject constructor(private val cloudflareRepository: CloudflareRepository) {
    suspend operator fun invoke(token: String, page: Int): ZoneList {
        return cloudflareRepository.getZones(token, page)
    }
}
