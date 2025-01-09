package club.vas3k.app.root.model

import kotlinx.serialization.Serializable

@Serializable
sealed interface RootNavigationConfig {
    @Serializable
    data object Auth : RootNavigationConfig
}
