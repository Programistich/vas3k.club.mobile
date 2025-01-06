package club.vas3k.core.log

import club.vas3k.core.buildkonfig.BuildKonfig

@Suppress("PropertyName")
interface LogTagProvider {
    @Suppress("VariableNaming")
    val TAG: String
}

inline fun LogTagProvider.error(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.error(TAG, logMessage)
    }
}

inline fun LogTagProvider.error(error: Throwable?, logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        if (error == null) {
            club.vas3k.core.log.error(TAG, logMessage)
        } else {
            club.vas3k.core.log.error(TAG, error, logMessage)
        }
    }
}

inline fun LogTagProvider.info(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.info(TAG, logMessage)
    }
}

inline fun LogTagProvider.verbose(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.verbose(TAG, logMessage)
    }
}

inline fun LogTagProvider.warn(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.warn(TAG, logMessage)
    }
}

inline fun LogTagProvider.debug(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.debug(TAG, logMessage)
    }
}

inline fun LogTagProvider.wtf(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.wtf(TAG, logMessage)
    }
}
