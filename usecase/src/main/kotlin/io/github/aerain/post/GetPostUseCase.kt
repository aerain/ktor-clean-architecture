package io.github.aerain.post

import java.time.Instant

class GetPostUseCase {
    operator fun invoke() = Post(
        "The Adventures of Tom Sawyer",
        "Mark Twain",
        Instant.now()
    )
}