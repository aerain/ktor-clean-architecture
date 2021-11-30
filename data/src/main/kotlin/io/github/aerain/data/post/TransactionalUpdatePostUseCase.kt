package io.github.aerain.data.post

import io.github.aerain.usecase.post.PostRepository
import io.github.aerain.usecase.post.UpdatePostRequest
import io.github.aerain.usecase.post.UpdatePostUseCase
import kotlinx.coroutines.CoroutineDispatcher
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TransactionalUpdatePostUseCase(
    repository: PostRepository,
    private val dispatcher: CoroutineDispatcher
): UpdatePostUseCase(repository) {
    override suspend fun invoke(request: UpdatePostRequest) = newSuspendedTransaction(dispatcher) {
        super.invoke(request)
    }
}