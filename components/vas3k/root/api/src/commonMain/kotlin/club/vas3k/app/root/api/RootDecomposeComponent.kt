package club.vas3k.app.root.api

import club.vas3k.app.root.model.RootNavigationConfig
import club.vas3k.ui.decompose.CompositeDecomposeComponent
import com.arkivanov.decompose.ComponentContext

abstract class RootDecomposeComponent : CompositeDecomposeComponent<RootNavigationConfig>() {
    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext
        ): RootDecomposeComponent
    }
}
