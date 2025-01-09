package club.vas3k.app.backend.di

import io.ktor.client.engine.js.Js

actual fun httpEngine() = Js.create()
