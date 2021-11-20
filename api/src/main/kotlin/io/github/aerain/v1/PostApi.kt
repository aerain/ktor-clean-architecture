package io.github.aerain.v1

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import java.time.Instant

class PostApi : Api({
    get("/post") {
        call.respond(
            Post(
                "The Adventures of Tom Sawyer",
                "Mark Twain",
                Instant.now()
            )
        )
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