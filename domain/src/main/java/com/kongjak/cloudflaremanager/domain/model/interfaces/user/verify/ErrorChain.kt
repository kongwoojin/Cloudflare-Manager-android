package com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify

interface ErrorChain {
    val code: Int
    val message: String
}
