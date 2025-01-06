package club.vas3k.app.root.api

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.ComponentContext
import club.vas3k.ui.decompose.ScreenDecomposeComponent
import me.tatarka.inject.annotations.Assisted
import me.tatarka.inject.annotations.Inject

@Inject
class RootScreenDecomposeComponentImpl(
    @Assisted componentContext: ComponentContext
) : ScreenDecomposeComponent(componentContext) {
    @Composable
    override fun Render(modifier: Modifier) {
        Box(
            modifier,
            contentAlignment = Alignment.Center
        ) {
            Text("Hello!")
        }
    }
}