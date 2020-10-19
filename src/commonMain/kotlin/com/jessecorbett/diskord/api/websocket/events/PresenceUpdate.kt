package com.jessecorbett.diskord.api.websocket.events

import com.jessecorbett.diskord.api.model.BareUser
import com.jessecorbett.diskord.api.model.UserStatus
import com.jessecorbett.diskord.api.websocket.model.UserStatusActivity
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// FIXME: Need to remove fields instead of deprecating
@Serializable
data class PresenceUpdate(
    @SerialName("user") val user: BareUser,
    @Deprecated("This field has been removed from the Discord API with no replacement.", level = DeprecationLevel.ERROR)
    @SerialName("roles") val roleIds: List<String> = listOf(),
    @Deprecated("This field has been removed from the Discord API. Use the first element of activities instead.", level = DeprecationLevel.ERROR, replaceWith = ReplaceWith("activities.firstOrNull()"))
    @SerialName("game") val activity: UserStatusActivity?,
    @SerialName("guild_id") val guildId: String,
    @SerialName("status") val status: UserStatus,
    @SerialName("activities") val activities: List<UserStatusActivity>
)
