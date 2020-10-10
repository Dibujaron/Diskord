package com.jessecorbett.diskord.util

import kotlinx.serialization.json.Json

/**
 * Default [Json] instance.
 */
internal val defaultJson = Json {
    ignoreUnknownKeys = true
    isLenient = true
    useArrayPolymorphism = true
}

/**
 * Relaxed [Json] instance that omits null values from (de-)serialized objects.
 */
internal val relaxedJson = Json(from = defaultJson) {
    encodeDefaults = false
}
