package io.github.aerain.v1

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.github.aerain.post.GetPostUseCase
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.time.Instant

class PostApi(
    private val getUseCase: GetPostUseCase
) : Api({
    get("/post") {
        call.respond(getUseCase())
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