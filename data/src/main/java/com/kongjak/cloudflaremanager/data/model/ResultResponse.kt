package com.kongjak.cloudflaremanager.data.model

import com.google.gson.annotations.SerializedName
import com.kongjak.cloudflaremanager.domain.model.interfaces.Result

data class ResultResponse(
    override val account: AccountResponse,
    @SerializedName("activated_on")
    override val activatedOn: String,
    @SerializedName("created_on")
    override val createdOn: String,
    @SerializedName("development_mode")
    override val developmentMode: Int,
    override val id: String,
    override val meta: MetaResponse,
    @SerializedName("modified_on")
    override val modifiedOn: String,
    override val name: String,
    @SerializedName("name_servers")
    override val nameServers: List<String>,
    @SerializedName("original_dnshost")
    override val originalDnshost: Any,
    @SerializedName("original_name_servers")
    override val originalNameServers: List<String>,
    @SerializedName("original_registrar")
    override val originalRegistrar: String,
    override val owner: OwnerResponse,
    override val paused: Boolean,
    override val permissions: List<String>,
    override val plan: PlanResponse,
    override val status: String,
    override val tenant: TenantResponse,
    @SerializedName("tenant_unit")
    override val tenantUnit: TenantUnitResponse,
    override val type: String
) : Result
