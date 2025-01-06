package club.vas3k.core.ktx.common

import kotlinx.coroutines.CoroutineDispatcher

/**
 * To be able to mock dispatchers
 */
object AppDispatchers {
    val default: CoroutineDispatcher by lazy { club.vas3k.core.ktx.common.getDispatcher() }
}

internal expect fun getDispatcher(): CoroutineDispatcher
