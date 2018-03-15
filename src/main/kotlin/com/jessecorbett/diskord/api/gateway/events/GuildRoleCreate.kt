package com.jessecorbett.diskord.api.gateway.events

import com.fasterxml.jackson.annotation.JsonProperty
import com.jessecorbett.diskord.api.Role

data class GuildRoleCreate(
        @JsonProperty("guild_id") val guildId: String,
        @JsonProperty("role") val role: Role
)
