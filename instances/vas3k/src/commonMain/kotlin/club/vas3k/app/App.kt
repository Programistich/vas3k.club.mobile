package club.vas3k.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import club.vas3k.app.core.theme.Vas3kTheme
import club.vas3k.app.di.AppComponent
import club.vas3k.app.preference.model.SettingsEnum
import club.vas3k.app.root.api.RootDecomposeComponent

@Composable
fun App(
    rootComponent: RootDecomposeComponent,
    appComponent: AppComponent,
    modifier: Modifier = Modifier
) {
    val isDarkMode by remember {
        appComponent.preferenceApi.getFlowBoolean(
            SettingsEnum.DARK_THEME,
            false
        )
    }.collectAsState(false)

    Vas3kTheme(isDarkMode) {
        rootComponent.Render(
            modifier
                .fillMaxSize()
        )
    }
}
