package io.github.aerain.usecase.post

import io.github.aerain.usecase.UseCase
import java.time.Instant
import io.github.aerain.entity.post.Post as PostEntity

@UseCase
class CreatePostUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(request: CreatePostRequest): Post {
        val post = request.toEntity()
        return repository.save(post).toDto()
    }

    private fun CreatePostRequest.toEntity() = PostEntity(
        title = this.title,
        author = this.author,
        postAt = Instant.now()
    )
}

data class CreatePostRequest(
    val title: String,
    val author: String
)
