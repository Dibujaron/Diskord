package com.jessecorbett.diskord.api.rest

import com.jessecorbett.diskord.api.model.Color
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateGuildRole(
        @SerialName("name") val name: String,
        @SerialName("permissions") val permissions: Int, // TODO: convert bitwise amounts
        @SerialName("color") val color: Color?,
        @SerialName("hoist") val displayedSeparately: Boolean,
        @SerialName("mentionable") val mentionable: Boolean
)