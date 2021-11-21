package io.github.aerain.api.v1.post

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.aerain.api.Api
import io.github.aerain.api.common.PaginationResponse
import io.github.aerain.usecase.post.GetAllPostUseCase
import io.github.aerain.usecase.post.GetPostUseCase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.*
import kotlinx.coroutines.flow.toList
import org.slf4j.Logger
import java.time.Instant

private const val DEFAULT_PAGE: Long = 0
private const val DEFAULT_SIZE = 20

class PostApi(
    private val getUseCase: GetPostUseCase,
    private val getAllUseCase: GetAllPostUseCase,
) : Api({
    route("/posts") {
        get {
            val page = call.request.queryParameters["page"]?.toLong() ?: DEFAULT_PAGE
            val size = call.request.queryParameters["size"]?.toInt() ?: DEFAULT_SIZE
            val result = getAllUseCase(page, size).toList()
            call.respond(PaginationResponse(page, size, result))
        }

        get("/{id}") {
            val id: Long by call.parameters
            call.respond(getUseCase(id))
        }
    }
})

data class Post @JsonCreator constructor(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("author")
    val author: String,
    @JsonProperty("post_at")
    val postAt: Instant
)