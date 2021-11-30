package io.github.aerain.data.post

import io.github.aerain.usecase.post.GetPostUseCase
import io.github.aerain.usecase.post.Post
import io.github.aerain.usecase.post.PostRepository
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class TransactionalGetPostUseCase(
    repository: PostRepository,
    private val dispatcher: CoroutineDispatcher
): GetPostUseCase(repository) {
    override suspend fun invoke(id: Long) = newSuspendedTransaction(dispatcher) { super.invoke(id) }
}