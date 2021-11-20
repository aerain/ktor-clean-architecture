package io.github.aerain.plugins

import io.github.aerain.v1.PostApi
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    routing {
        val apis = listOf(PostApi())
        apis.forEach { api -> api(this@configureRouting) }
    }
}
