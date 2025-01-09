package club.vas3k.app.root.api

import club.vas3k.app.auth.api.AuthDecomposeComponent
import club.vas3k.app.root.model.RootNavigationConfig
import club.vas3k.core.di.AppGraph
import club.vas3k.ui.decompose.DecomposeComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@Inject
class RootDecomposeComponentImpl(
    @Assisted componentContext: ComponentContext,
    private val authDecomposeComponentFactory: AuthDecomposeComponent.Factory,
) : RootDecomposeComponent(),
    ComponentContext by componentContext {
    override val stack = childStack(
        source = navigation,
        serializer = RootNavigationConfig.serializer(),
        initialConfiguration = RootNavigationConfig.Auth,
        handleBackButton = true,
        childFactory = ::child,
    )

    private fun child(
        config: RootNavigationConfig,
        componentContext: ComponentContext
    ): DecomposeComponent = when (config) {
        RootNavigationConfig.Auth -> authDecomposeComponentFactory(componentContext)
    }

    @Inject
    @ContributesBinding(AppGraph::class, RootDecomposeComponent.Factory::class)
    class Factory(
        private val factory: (
            componentContext: ComponentContext
        ) -> RootDecomposeComponentImpl
    ) : RootDecomposeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext
        ) = factory(componentContext)
    }
}
