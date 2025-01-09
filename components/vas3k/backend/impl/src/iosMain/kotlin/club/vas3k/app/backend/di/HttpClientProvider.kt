package club.vas3k.app.backend.di

import io.ktor.client.engine.cio.CIO

actual fun httpEngine() = CIO.create()
