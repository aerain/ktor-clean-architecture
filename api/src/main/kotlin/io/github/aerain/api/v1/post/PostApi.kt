package io.github.aerain.api.v1.post

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.aerain.api.Api
import io.github.aerain.api.common.PaginationResponse
import io.github.aerain.usecase.post.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.*
import java.time.Instant
import io.github.aerain.usecase.post.CreatePostRequest as UseCaseCreatePostRequest

private const val DEFAULT_PAGE: Long = 0
private const val DEFAULT_SIZE = 20

class PostApi(
    private val getUseCase: GetPostUseCase,
    private val getAllUseCase: GetAllPostUseCase,
    private val createUseCase: CreatePostUseCase,
    private val deletePostUseCase: DeletePostUseCase
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

        post {
            val request = call.receive<CreatePostRequest>().toRequest()
            call.respond(createUseCase(request))
        }

        delete("/{id}") {
            val id: Long by call.parameters
            call.respond(deletePostUseCase(id))
        }
    }
})

private fun CreatePostRequest.toRequest() = UseCaseCreatePostRequest(title, author)

data class Post @JsonCreator constructor(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("author")
    val author: String,
    @JsonProperty("post_at")
    val postAt: Instant
)

data class CreatePostRequest @JsonCreator constructor(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("author")
    val author: String
)