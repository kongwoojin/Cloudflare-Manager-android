package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.repository.UserRepository
import javax.inject.Inject

class SetUserTokenUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(token: String) {
        userRepository.setUserToken(token)
    }
}