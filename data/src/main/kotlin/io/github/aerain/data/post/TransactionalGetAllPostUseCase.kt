package io.github.aerain.data.post

import io.github.aerain.usecase.post.GetAllPostUseCase
import io.github.aerain.usecase.post.PostRepository
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class TransactionalGetAllPostUseCase(repository: PostRepository): GetAllPostUseCase(repository) {
    override suspend fun invoke(page: Long, size: Int) = newSuspendedTransaction {
        super.invoke(page, size)
    }
}