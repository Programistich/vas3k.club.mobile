package club.vas3k.app.auth.api

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import club.vas3k.app.auth.model.AuthRootNavigationConfig
import club.vas3k.core.di.AppGraph
import club.vas3k.core.log.LogTagProvider
import club.vas3k.ui.decompose.DecomposeComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.childStack
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@Inject
class AuthDecomposeComponentImpl(
    @Assisted componentContext: ComponentContext,
    private val authRootScreenDecomposeComponent: (
        ComponentContext,
    ) -> AuthRootScreenDecomposeComponent,
) : AuthDecomposeComponent<AuthRootNavigationConfig>(),
    ComponentContext by componentContext, LogTagProvider {
    override val TAG = "AuthDecomposeComponentImpl"

    override val stack = childStack(
        source = navigation,
        serializer = AuthRootNavigationConfig.serializer(),
        initialStack = { listOf(AuthRootNavigationConfig.AuthRoot) },
        handleBackButton = true,
        childFactory = ::child,
    )

    @Composable
    override fun Render(modifier: Modifier) {
        super.Render(modifier)
    }

    private fun child(
        config: AuthRootNavigationConfig,
        componentContext: ComponentContext
    ): DecomposeComponent = when (config) {
        AuthRootNavigationConfig.AuthRoot -> authRootScreenDecomposeComponent(componentContext)
    }

    @Inject
    @ContributesBinding(AppGraph::class, AuthDecomposeComponent.Factory::class)
    class Factory(
        private val factory: (
            componentContext: ComponentContext,
        ) -> AuthDecomposeComponentImpl
    ) : AuthDecomposeComponent.Factory {
        override fun invoke(
            componentContext: ComponentContext,
        ) = factory(componentContext)
    }
}
