package com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify

interface Message {
    val code: Int
    val message: String
    val type: Any
}
