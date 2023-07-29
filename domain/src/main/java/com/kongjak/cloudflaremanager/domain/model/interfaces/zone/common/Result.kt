package com.kongjak.cloudflaremanager.domain.model.interfaces.zone.common

interface Result {
    val account: Account
    val activatedOn: String
    val createdOn: String
    val developmentMode: Int
    val id: String
    val meta: Meta
    val modifiedOn: String
    val name: String
    val nameServers: List<String>
    val originalDnshost: Any
    val originalNameServers: List<String>
    val originalRegistrar: String
    val owner: Owner
    val paused: Boolean
    val permissions: List<String>
    val plan: Plan
    val status: String
    val tenant: Tenant
    val tenantUnit: TenantUnit
    val type: String
}
