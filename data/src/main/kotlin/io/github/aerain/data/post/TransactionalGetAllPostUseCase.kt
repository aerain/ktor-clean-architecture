package io.github.aerain.data.post

import io.github.aerain.usecase.post.GetAllPostUseCase
import io.github.aerain.usecase.post.PostRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TransactionalGetAllPostUseCase(
    repository: PostRepository,
    private val dispatcher: CoroutineDispatcher
): GetAllPostUseCase(repository) {
    override suspend fun invoke(page: Long, size: Int) = newSuspendedTransaction(dispatcher) {
        super.invoke(page, size)
    }
}