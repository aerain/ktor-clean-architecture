package io.github.aerain.api

import io.ktor.server.application.*
import io.ktor.server.routing.*

abstract class Api(val route: Routing.() -> Unit) {
    operator fun invoke(app: Application) = app.routing {
        route()
    }
}