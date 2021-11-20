package io.github.aerain.plugins

import io.github.aerain.apis
import io.ktor.application.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        log.info("registered api. {}", apis.map { it.javaClass.simpleName })
        apis.forEach { api -> api(this@configureRouting) }
    }
}
