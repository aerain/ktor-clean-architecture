package io.github.aerain.api.exception

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.aerain.usecase.exception.BaseException
import io.github.aerain.usecase.exception.NotFoundException
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun StatusPages.Configuration.exceptionHandler() {

    exception<NotFoundException> { cause ->
        call.respond(HttpStatusCode.NotFound, ErrorResponse(cause.message))
    }

    exception<BaseException> { cause ->
        call.respond(HttpStatusCode.BadRequest, ErrorResponse(cause.message))
    }

    exception<Exception> { cause ->
        call.respond(HttpStatusCode.InternalServerError, ErrorResponse(cause.message))
        throw cause
    }
}

data class ErrorResponse @JsonCreator constructor(
    @JsonProperty("message")
    val message: String?
)