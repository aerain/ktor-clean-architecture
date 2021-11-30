package io.github.aerain.usecase.post

import io.github.aerain.usecase.UseCase
import io.github.aerain.usecase.exception.NotFoundException

@UseCase
class UpdatePostUseCase(
    private val postRepository: PostRepository
) {
    suspend operator fun invoke(request: UpdatePostRequest) {
        val post = postRepository.findById(request.id) ?: throw NotFoundException("id")
        post.changeTitle(request.title)
        postRepository.update(post)
    }

}

data class UpdatePostRequest(
    val id: Long,
    val title: String,
)

