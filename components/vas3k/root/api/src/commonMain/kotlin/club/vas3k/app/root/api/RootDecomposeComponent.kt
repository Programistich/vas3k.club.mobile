package club.vas3k.app.root.api

import club.vas3k.app.root.model.RootNavigationConfig
import com.arkivanov.decompose.ComponentContext
import club.vas3k.ui.decompose.CompositeDecomposeComponent

abstract class RootDecomposeComponent : CompositeDecomposeComponent<RootNavigationConfig>() {
    fun interface Factory {
        operator fun invoke(
            componentContext: ComponentContext
        ): RootDecomposeComponent
    }
}