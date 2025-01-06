package club.vas3k.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import club.vas3k.app.di.AndroidAppComponent
import club.vas3k.app.root.api.RootDecomposeComponent
import club.vas3k.core.di.ComponentHolder
import club.vas3k.core.ktx.android.toFullString
import club.vas3k.core.log.LogTagProvider
import club.vas3k.core.log.info

class MainActivity : ComponentActivity(), LogTagProvider {
    override val TAG = "MainActivity"

    private var rootDecomposeComponent: RootDecomposeComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            info {
                "Create new activity with hashcode: ${this.hashCode()} " + "and intent ${intent.toFullString()}"
            }
        } else {
            info {
                "Restore activity from backstack, so return from onCreate method"
            }
        }

        enableEdgeToEdge()

        val appComponent = ComponentHolder.component<AndroidAppComponent>()

        val rootComponent = appComponent.rootDecomposeComponentFactory(
            defaultComponentContext()
        ).also { rootDecomposeComponent = it }

        setContent {
            App(rootComponent, appComponent)
        }
    }
}
