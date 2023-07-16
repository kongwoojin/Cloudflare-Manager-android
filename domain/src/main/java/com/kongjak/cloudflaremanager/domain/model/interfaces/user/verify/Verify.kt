package com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify

import com.kongjak.cloudflaremanager.domain.model.interfaces.Error
import com.kongjak.cloudflaremanager.domain.model.interfaces.Message

interface Verify{
    val errors: List<Error>?
    val messages: List<Message>
    val result: List<Result>
    val success: Boolean
}