package club.vas3k.app.auth.api

import club.vas3k.ui.decompose.CompositeDecomposeComponent
import com.arkivanov.decompose.ComponentContext

abstract class AuthDecomposeComponent<T : Any> : CompositeDecomposeComponent<T>() {
    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext,
        ): AuthDecomposeComponent<*>
    }
}
