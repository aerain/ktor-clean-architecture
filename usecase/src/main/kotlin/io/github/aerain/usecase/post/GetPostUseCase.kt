package io.github.aerain.usecase.post

import io.github.aerain.usecase.UseCase
import java.time.Instant

@UseCase
class GetPostUseCase {
    operator fun invoke() = Post(
        "The Adventures of Tom Sawyer",
        "Mark Twain",
        Instant.now()
    )
}