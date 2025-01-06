import androidx.compose.ui.window.ComposeUIViewController
import club.vas3k.core.ktx.common.AppDispatchers
import com.arkivanov.decompose.ComponentContext
import club.vas3k.app.App
import club.vas3k.app.di.IOSAppComponent
import club.vas3k.app.di.create
import com.russhwolf.settings.Settings
import com.russhwolf.settings.observable.makeObservable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import platform.UIKit.UIViewController

@Suppress("FunctionNaming")
fun MainViewController(
    componentContext: ComponentContext,
    settings: Settings
): UIViewController {
    val applicationScope = CoroutineScope(
        SupervisorJob() + AppDispatchers.default
    )
    val appComponent = IOSAppComponent::class.create(
        settings.makeObservable(),
        applicationScope
    )
    val rootComponent = appComponent.rootDecomposeComponentFactory(
        componentContext
    )
    return ComposeUIViewController {
        App(rootComponent, appComponent)
    }
}
