package io.github.aerain.api

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.aerain.usecase.post.GetPostUseCase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.util.*
import java.time.Instant

class PostApi(
    private val getUseCase: GetPostUseCase
) : Api({
    get("/post/{id}") {
        val id = call.parameters.getOrFail<Long>("id")
        call.respond(getUseCase(id))
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