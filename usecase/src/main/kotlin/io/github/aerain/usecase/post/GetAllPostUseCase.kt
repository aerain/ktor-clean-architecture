package io.github.aerain.usecase.post

import io.github.aerain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@UseCase
class GetAllPostUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(page: Long, size: Int): Flow<Post> {
        return repository.findAll(page, size).map { it.toDto() }
    }
}
