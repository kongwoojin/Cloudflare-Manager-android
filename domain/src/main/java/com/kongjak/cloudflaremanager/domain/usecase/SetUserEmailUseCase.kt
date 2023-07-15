package com.kongjak.cloudflaremanager.domain.usecase

import com.kongjak.cloudflaremanager.domain.repository.UserRepository
import javax.inject.Inject

class SetUserEmailUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(email: String) {
        userRepository.setUserEmail(email)
    }
}