package club.vas3k.app.backend.di

import club.vas3k.app.preference.api.PreferenceApi
import club.vas3k.app.preference.model.SettingsEnum
import club.vas3k.core.di.AppGraph
import club.vas3k.core.log.TaggedLogger
import club.vas3k.core.log.verbose
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import me.tatarka.inject.annotations.Provides
import software.amazon.lastmile.kotlin.inject.anvil.ContributesTo

private val ktorTimber = TaggedLogger("Ktor")

@ContributesTo(AppGraph::class)
interface HttpClientComponent {
    @Provides
    fun provideHttpClient(preferenceApi: PreferenceApi): HttpClient = getHttpClient(preferenceApi)
}

fun getHttpClient(preferenceApi: PreferenceApi) = HttpClient(httpEngine()) {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
                coerceInputValues = true
            }
        )
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                ktorTimber.verbose { message }
            }
        }
        level = LogLevel.ALL
    }

    install(Auth) {
        bearer {
            loadTokens {
                val accessToken = preferenceApi.getString(SettingsEnum.ACCESS_TOKEN, null)
                val refreshToken = preferenceApi.getString(SettingsEnum.REFRESH_TOKEN, null)

                BearerTokens(
                    accessToken = accessToken ?: "",
                    refreshToken = refreshToken?: ""
                )
            }
            refreshTokens {
               //

                BearerTokens(
                    accessToken = "",
                    refreshToken = ""
                )
            }
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }
}

expect fun httpEngine(): HttpClientEngine
