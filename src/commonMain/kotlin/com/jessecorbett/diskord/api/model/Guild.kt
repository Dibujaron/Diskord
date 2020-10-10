package com.jessecorbett.diskord.api.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@Serializable
data class Guild(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("icon") val iconHash: String?,
    @SerialName("splash") val splashHash: String?,
    @SerialName("owner") val userIsOwner: Boolean? = null,
    @SerialName("owner_id") val ownerId: String,
    @SerialName("permissions") val permissions: Permissions? = null,
    @SerialName("region") val region: String,
    @SerialName("afk_channel_id") val afkChannelId: String?,
    @SerialName("afk_timeout") val afkTimeoutSeconds: Int,
    @SerialName("embed_enabled") val embedEnabled: Boolean? = null,
    @SerialName("embed_channel_id") val embeddedChannelId: String? = null,
    @SerialName("verification_level") val verificationLevel: VerificationLevel,
    @SerialName("default_message_notifications") val defaultMessageNotificationLevel: NotificationsLevel,
    @SerialName("explicit_content_filter") val explicitContentFilterLevel: ExplicitContentFilterLevel,
    @SerialName("roles") val roles: List<Role>,
    @SerialName("emojis") val emojis: List<Emoji>,
    @SerialName("features") val features: List<String>,
    @SerialName("mfa_level") val mfaLevel: MFALevel,
    @SerialName("application_id") val owningApplicationId: String?,
    @SerialName("widget_enabled") val widgetEnabled: Boolean? = null,
    @SerialName("widget_channel_id") val widgetChannelId: String? = null,
    @SerialName("system_channel_id") val systemMessageChannelId: String?
)

@Serializable(with = VerificationLevelSerializer::class)
enum class VerificationLevel(val level: Int) {
    NONE(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    VERY_HIGH(4)
}

object VerificationLevelSerializer : KSerializer<VerificationLevel> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("VerificationLevelSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): VerificationLevel {
        val target = decoder.decodeInt()
        return VerificationLevel.values().first {
            it.level == target
        }
    }

    override fun serialize(encoder: Encoder, value: VerificationLevel) {
        encoder.encodeInt(value.level)
    }
}

@Serializable(with = NotificationsLevelSerializer::class)
enum class NotificationsLevel(val level: Int) {
    ALL_MESSAGES(0),
    ONLY_MENTIONS(1)
}

object NotificationsLevelSerializer : KSerializer<NotificationsLevel> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("NotificationsLevelSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): NotificationsLevel {
        val target = decoder.decodeInt()
        return NotificationsLevel.values().first {
            it.level == target
        }
    }

    override fun serialize(encoder: Encoder, value: NotificationsLevel) {
        encoder.encodeInt(value.level)
    }
}

@Serializable(with = ExplicitContentFilterLevelSerializer::class)
enum class ExplicitContentFilterLevel(val level: Int) {
    DISABLED(0),
    MEMBERS_WITHOUT_ROLES(1),
    ALL_MEMBERS(2)
}

object ExplicitContentFilterLevelSerializer : KSerializer<ExplicitContentFilterLevel> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("ExplicitContentFilterLevelSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): ExplicitContentFilterLevel {
        val target = decoder.decodeInt()
        return ExplicitContentFilterLevel.values().first {
            it.level == target
        }
    }

    override fun serialize(encoder: Encoder, value: ExplicitContentFilterLevel) {
        encoder.encodeInt(value.level)
    }
}

@Serializable(with = MFALevelSerializer::class)
enum class MFALevel(val level: Int) {
    NONE(0),
    ELEVATED(1)
}

object MFALevelSerializer : KSerializer<MFALevel> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("MFALevelSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): MFALevel {
        val target = decoder.decodeInt()
        return MFALevel.values().first {
            it.level == target
        }
    }

    override fun serialize(encoder: Encoder, value: MFALevel) {
        encoder.encodeInt(value.level)
    }
}
