package io.github.aerain.data.post

import io.github.aerain.usecase.post.DeletePostUseCase
import io.github.aerain.usecase.post.PostRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TransactionalDeletePostUseCase(
    repository: PostRepository,
    private val dispatcher: CoroutineDispatcher
): DeletePostUseCase(repository) {
    override suspend fun invoke(id: Long) = newSuspendedTransaction(dispatcher) {
        super.invoke(id)
    }
}