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
data class User(
    @SerialName("id") val id: String,
    @SerialName("username") val username: String,
    @SerialName("discriminator") val discriminator: Long,
    @SerialName("avatar") val avatarHash: String?,
    @SerialName("bot") val isBot: Boolean = false,
    @SerialName("mfa_enabled") val twoFactorAuthEnabled: Boolean? = null,
    @SerialName("locale") val locale: String? = null,
    @SerialName("verified") val isVerified: Boolean? = null,
    @SerialName("email") val email: String? = null
//    @SerialName("flags") val flags: Int = 0, // TODO: https://discordapp.com/developers/docs/resources/user#user-object-user-flags
//    @SerialName("premium_type") val premiumType: PremiumType? = null
)

@Serializable(with = UserFlagsSerializer::class)
enum class UserFlags(val code: Int) {
    NONE(0),
    HYPESQUAD_EVENTS(1 shl 2),
    HOUSE_BRAVERY(1 shl 6),
    HOUSE_BRILLIANCE(1 shl 7),
    HOUSE_BALANCE(1 shl 8)
}

object UserFlagsSerializer : KSerializer<UserFlags> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("UserFlagsSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): UserFlags {
        val target = decoder.decodeInt()
        return UserFlags.values().first {
            it.code == target
        }
    }

    override fun serialize(encoder: Encoder, value: UserFlags) {
        encoder.encodeInt(value.code)
    }
}

@Serializable(with = PremiumTypeSerializer::class)
enum class PremiumType(val code: Int) {
    NONE(0),
    NITRO_CLASSIC(1),
    NITRO(2)
}

object PremiumTypeSerializer : KSerializer<PremiumType> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("PremiumTypeSerializer", PrimitiveKind.INT)

    override fun deserialize(decoder: Decoder): PremiumType {
        val target = decoder.decodeInt()
        return PremiumType.values().first {
            it.code == target
        }
    }

    override fun serialize(encoder: Encoder, value: PremiumType) {
        encoder.encodeInt(value.code)
    }
}
