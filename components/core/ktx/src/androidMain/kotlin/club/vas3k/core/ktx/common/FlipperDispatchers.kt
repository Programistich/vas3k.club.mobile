package club.vas3k.core.ktx.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors

internal actual fun getDispatcher(): CoroutineDispatcher {
    return Executors.newWorkStealingPool().asCoroutineDispatcher()
}
