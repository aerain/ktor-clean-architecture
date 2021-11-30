package io.github.aerain.usecase.post

import io.github.aerain.usecase.UseCase

@UseCase
class DeletePostUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(id: Long) {
        repository.deleteById(id)
    }
}