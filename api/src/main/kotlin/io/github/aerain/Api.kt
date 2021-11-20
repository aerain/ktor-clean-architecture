package io.github.aerain

import io.ktor.application.*
import io.ktor.routing.*

abstract class Api(val route: Routing.() -> Unit) {
    operator fun invoke(app: Application) = app.routing {
        route()
    }
}