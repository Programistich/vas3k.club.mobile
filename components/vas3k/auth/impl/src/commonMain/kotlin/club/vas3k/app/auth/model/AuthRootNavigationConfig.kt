package club.vas3k.app.auth.model

import kotlinx.serialization.Serializable

@Serializable
sealed interface AuthRootNavigationConfig {
    @Serializable
    data object AuthRoot : AuthRootNavigationConfig
}
