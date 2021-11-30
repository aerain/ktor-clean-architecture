package io.github.aerain.data.post

import io.github.aerain.usecase.post.PostRepository
import io.github.aerain.usecase.post.UpdatePostRequest
import io.github.aerain.usecase.post.UpdatePostUseCase
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TransactionalUpdatePostUseCase(
    repository: PostRepository
): UpdatePostUseCase(repository) {
    override suspend fun invoke(request: UpdatePostRequest) = newSuspendedTransaction {
        super.invoke(request)
    }
}