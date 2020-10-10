package com.jessecorbett.diskord.api.websocket.commands

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdentifyShard(
    @SerialName("token") val token: String,
    @SerialName("shard") val shard: List<Int>,
    @SerialName("compress") val canCompress: Boolean = false,
    @SerialName("large_threshold") val memberCountThreshold: Int = 50,
    @SerialName("intents") val intents: Int,
    @SerialName("presence") val presence: UpdateStatus? = null,
    @SerialName("properties") val properties: IdentifyProperties
)

@Serializable
data class Identify(
    @SerialName("token") val token: String,
    @SerialName("compress") val canCompress: Boolean = false,
    @SerialName("large_threshold") val memberCountThreshold: Int = 50,
    @SerialName("intents") val intents: Int,
    @SerialName("presence") val presence: UpdateStatus? = null,
    @SerialName("properties") val properties: IdentifyProperties
)

@Serializable
data class IdentifyProperties(
    @SerialName("\$os") val os: String, // TODO: Make multiplatform
    @SerialName("\$browser") val browser: String,
    @SerialName("\$device") val device: String
)
