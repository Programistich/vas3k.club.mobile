package club.vas3k.app.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.arkivanov.decompose.extensions.compose.stack.animation.LocalStackAnimationProvider

@Composable
fun Vas3kTheme(
    darkMode: Boolean,
    content: @Composable () -> Unit
) {
    val isLight = if (darkMode) {
        false
    } else {
        isSystemInDarkTheme().not()
    }
    Vas3kThemeInternal(
        isLight = isLight,
        content = content
    )
}

@Composable
fun Vas3kThemeInternal(
    isLight: Boolean = true,
    content: @Composable () -> Unit,
) {
    MaterialTheme() {
        CompositionLocalProvider(
            LocalStackAnimationProvider provides AppAnimationProvider,
            content = content
        )
    }
}
