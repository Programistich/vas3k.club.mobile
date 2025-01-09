package club.vas3k.app.auth.api

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import club.vas3k.app.auth.vm.AuthMainViewModel
import club.vas3k.core.ui.lifecycle.viewModelWithFactory
import club.vas3k.ui.decompose.ScreenDecomposeComponent
import com.arkivanov.decompose.ComponentContext
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject

@Inject
class AuthRootScreenDecomposeComponent(
    @Assisted componentContext: ComponentContext,
    authMainViewModel: () -> AuthMainViewModel,
) : ScreenDecomposeComponent(componentContext) {

    private val authViewModel = viewModelWithFactory(null) {
        authMainViewModel()
    }

    @Composable
    override fun Render(modifier: Modifier) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text("Test")
        }
    }
}
