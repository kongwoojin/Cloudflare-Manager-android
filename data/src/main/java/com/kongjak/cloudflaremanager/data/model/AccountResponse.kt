package com.kongjak.cloudflaremanager.data.model

import com.kongjak.cloudflaremanager.domain.model.interfaces.Account

data class AccountResponse(
    override val id: String,
    override val name: String
) : Account
