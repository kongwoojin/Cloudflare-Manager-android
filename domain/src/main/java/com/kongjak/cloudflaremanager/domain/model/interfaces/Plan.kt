package com.kongjak.cloudflaremanager.domain.model.interfaces

interface Plan{
    val canSubscribe: Boolean
    val currency: String
    val externallyManaged: Boolean
    val frequency: String
    val id: String
    val isSubscribed: Boolean
    val legacyDiscount: Boolean
    val legacyId: String
    val name: String
    val price: Int
}