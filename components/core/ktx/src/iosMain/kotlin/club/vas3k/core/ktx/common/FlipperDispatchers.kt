package club.vas3k.core.ktx.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal actual fun getDispatcher(): CoroutineDispatcher {
    return Dispatchers.Default
}
