package io.github.aerain.api.exception

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.aerain.usecase.exception.BaseException
import io.github.aerain.usecase.exception.NotFoundException
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*
import org.slf4j.LoggerFactory
import java.time.Instant

fun StatusPages.Configuration.exceptionHandler() {
    exception<NotFoundException> { cause ->
        call.respond(HttpStatusCode.NotFound, ErrorResponse(cause.message))
    }

    exception<BaseException> { cause ->
        call.respond(HttpStatusCode.BadRequest, ErrorResponse(cause.message))
    }

    exception<Exception> { cause ->
        val log = call.application.environment.log
        call.respond(HttpStatusCode.InternalServerError, ErrorResponse(cause.message))
        log.error("Exception was thrown.", cause)
    }
}

data class ErrorResponse @JsonCreator constructor(
    @JsonProperty("message")
    val message: String?,
    @JsonProperty("timestamp")
    val timestamp: Instant = Instant.now()
)