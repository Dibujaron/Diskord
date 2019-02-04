package com.jessecorbett.diskord.api.websocket.events

import com.jessecorbett.diskord.api.model.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GuildMemberAdd(
        @SerialName("user") val user: User,
        @SerialName("nick") val nickname: String? = null,
        @SerialName("roles") val roleIds: List<String>,
        @SerialName("joined_at") val joinedAt: String,
        @SerialName("deaf") val isDeaf: Boolean,
        @SerialName("mute") val isMute: Boolean,
        @SerialName("guild_id") val guildId: String
)