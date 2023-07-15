package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.repository.UserRepository
import javax.inject.Inject

class SetUserAPIKeyUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(apiKey: String) {
        userRepository.setUserAPIKey(apiKey)
    }
}