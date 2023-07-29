package com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list

interface Message {
    val code: Int
    val message: String
    val type: Any
}
