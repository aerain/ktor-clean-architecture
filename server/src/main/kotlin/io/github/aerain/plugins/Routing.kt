package io.github.aerain.plugins

import io.github.aerain.apis
import io.github.aerain.post.GetPostUseCase
import io.github.aerain.v1.PostApi
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    routing {
        apis.forEach { api -> api(this@configureRouting) }
    }
}
