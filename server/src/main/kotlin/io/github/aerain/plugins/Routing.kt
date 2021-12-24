package io.github.aerain.plugins

import io.github.aerain.api.Api
import io.ktor.application.*
import io.ktor.routing.*
import org.koin.ktor.ext.getKoin

fun Application.configureRouting() {
    val apis = getKoin().getAll<Api>().toSet()
    log.info("registered api. {}", apis.map { it.javaClass.simpleName })
    routing {
        apis.forEach { api -> api(this@configureRouting) }
    }
}
