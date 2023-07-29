package com.kongjak.cloudflaremanager.domain.model.interfaces.user.verify

import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.Error
import com.kongjak.cloudflaremanager.domain.model.interfaces.zone.list.Message

interface Verify {
    val errors: List<Error>?
    val messages: List<Message>
    val result: Result
    val success: Boolean
}
