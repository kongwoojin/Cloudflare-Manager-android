package com.kongjak.cloudflaremanager.data.model

import com.google.gson.annotations.SerializedName
import com.kongjak.cloudflaremanager.domain.model.interfaces.Plan

data class PlanResponse(
    @SerializedName("can_subscribe")
    override val canSubscribe: Boolean,
    override val currency: String,
    @SerializedName("externally_managed")
    override val externallyManaged: Boolean,
    override val frequency: String,
    override val id: String,
    @SerializedName("is_subscribed")
    override val isSubscribed: Boolean,
    @SerializedName("legacy_discount")
    override val legacyDiscount: Boolean,
    @SerializedName("legacy_id")
    override val legacyId: String,
    override val name: String,
    override val price: Int
) : Plan
