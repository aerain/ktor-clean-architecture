package io.github.aerain.usecase.post

import io.github.aerain.usecase.UseCase
import io.github.aerain.usecase.exception.NotFoundException

@UseCase
class GetPostUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(id: Long): Post {
        val entity = repository.findById(id) ?: throw NotFoundException(ID_NOT_FOUND)
        return entity.toDto()
    }

    companion object {
        private const val ID_NOT_FOUND = "id"
    }
}