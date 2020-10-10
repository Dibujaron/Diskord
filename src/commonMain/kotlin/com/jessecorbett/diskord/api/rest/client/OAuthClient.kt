package com.jessecorbett.diskord.api.rest.client

import com.jessecorbett.diskord.api.rest.BearerToken
import com.jessecorbett.diskord.api.rest.client.internal.DISCORD_API_URL
import com.jessecorbett.diskord.api.rest.client.internal.DefaultRestClient
import com.jessecorbett.diskord.api.rest.client.internal.RestClient
import com.jessecorbett.diskord.util.DiskordInternals
import com.jessecorbett.diskord.util.defaultJson


private const val AUTH_CODE = "authorization_code"
private const val REFRESH_TOKEN = "refresh_token"

/**
 * Basic implementation of the OAuth endpoints.
 *
 * @property clientId The OAuth clientId.
 * @property clientSecret the OAuth secret.
 * @property redirectUri The uri to redirect to as part of the OAuth flow.
 */
@OptIn(DiskordInternals::class)
class OAuthClient(
    private val clientId: String,
    private val clientSecret: String,
    private val redirectUri: String,
    private val baseUrl: String = DISCORD_API_URL,
    private val client: RestClient = DefaultRestClient()
) : RestClient by client {

    private suspend fun getToken(code: String, grantType: String): BearerToken {
        val form = hashMapOf(
            "client_id" to clientId,
            "client_secret" to clientSecret,
            "grant_type" to grantType,
            "redirect_uri" to redirectUri
        )

        form += if (grantType == AUTH_CODE) {
            "code" to code
        } else {
            "refresh_token" to code
        }

        val response = postForm("$baseUrl/oauth2/token", form)

        return defaultJson.decodeFromString(BearerToken.serializer(), response.body!!)
    }

    /**
     * Get the access token from a user's API token.
     *
     * @param token The user's API token.
     *
     * @return The bearer token information.
     * @throws com.jessecorbett.diskord.api.exception.DiscordException
     */
    suspend fun getAccessToken(token: String): BearerToken {
        return getToken(token, AUTH_CODE)
    }

    /**
     * Get the access token from a user's refresh.
     *
     * @param token The user's refresh token.
     *
     * @return The bearer token information.
     * @throws com.jessecorbett.diskord.api.exception.DiscordException
     */
    suspend fun getFromRefreshToken(token: String): BearerToken {
        return getToken(token, REFRESH_TOKEN)
    }
}
