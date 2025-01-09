package club.vas3k.app.backend.api

import club.vas3k.app.backend.NetworkConstants
import club.vas3k.app.backend.model.Vas3kTokenResponse
import club.vas3k.app.backend.model.Vas3kUserResponse
import club.vas3k.app.preference.api.PreferenceApi
import club.vas3k.app.preference.model.SettingsEnum
import club.vas3k.core.di.AppGraph
import club.vas3k.core.ktx.common.AppDispatchers
import club.vas3k.core.ktx.common.transform
import club.vas3k.core.log.LogTagProvider
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import kotlinx.coroutines.withContext
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

private val networkDispatcher = AppDispatchers.default

@Inject
@ContributesBinding(AppGraph::class, Vas3kClubAPI::class)
class Vas3kClubAPIImpl(
    private val httpClient: HttpClient,
    private val preferenceApi: PreferenceApi
) : Vas3kClubAPI, LogTagProvider {
    override val TAG = "Vas3kClubAPIImpl"

    override suspend fun getUser(): Result<Vas3kUserResponse> = withContext(networkDispatcher) {
        runCatching {
            httpClient.get {
                url("${NetworkConstants.HOST_URL}/user/me.json")
            }.body<Vas3kUserResponse>()
        }
    }

    override fun getAuthUrl(): String {
        val base = "${NetworkConstants.HOST_URL}/auth/openid/authorize"
        val params = listOf(
            "response_type=code",
            "client_id=${NetworkConstants.CLIENT_ID}",
            "scope=openid",
            "redirect_uri=${NetworkConstants.REDIRECT_URI}"
        )
        return "$base?${params.joinToString("&")}"
    }

    override suspend fun auth(pkceCode: String): Result<Unit> = withContext(networkDispatcher) {
        return@withContext runCatching {
            httpClient.post {
                url("${NetworkConstants.HOST_URL}/auth/openid/token")
                setBody(
                    listOf(
                        "grant_type" to "authorization_code",
                        "code" to pkceCode,
                        "redirect_uri" to NetworkConstants.REDIRECT_URI,
                        "client_id" to NetworkConstants.CLIENT_ID,
                        "client_secret" to NetworkConstants.CLIENT_SECRET
                    )
                )
            }.body<Vas3kTokenResponse>()
        }.onSuccess {
            preferenceApi.setString(SettingsEnum.ACCESS_TOKEN, it.accessToken)
            preferenceApi.setString(SettingsEnum.REFRESH_TOKEN, it.refreshToken)
        }.transform { getUser() }.map { }
    }
}