package com.kongjak.cloudflaremanager.domain.model.interfaces

interface Message {
    val code: Int
    val message: String
    val type: Any
}