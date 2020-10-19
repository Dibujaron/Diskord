package com.jessecorbett.diskord.api.websocket.commands

import com.jessecorbett.diskord.api.model.UserStatus
import com.jessecorbett.diskord.api.websocket.model.UserStatusActivity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UpdateStatus(
    @SerialName("since") val idleSince: Int? = null,
    @SerialName("status") val status: UserStatus = UserStatus.ONLINE,
    @SerialName("afk") val isAfk: Boolean = false,
    @SerialName("activities") val activities: List<UserStatusActivity>? = null
)
