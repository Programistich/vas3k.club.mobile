package club.vas3k.core.log

import club.vas3k.core.buildkonfig.BuildKonfig

inline fun error(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.error(null, logMessage)
    }
}

inline fun error(error: Throwable, logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.error(null, error, logMessage)
    }
}

inline fun info(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.info(null, logMessage)
    }
}

inline fun verbose(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.verbose(null, logMessage)
    }
}

inline fun warn(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.warn(null, logMessage)
    }
}

inline fun debug(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.debug(null, logMessage)
    }
}

inline fun wtf(logMessage: () -> String) {
    if (BuildKonfig.IS_LOG_ENABLED) {
        club.vas3k.core.log.wtf(null, logMessage)
    }
}
