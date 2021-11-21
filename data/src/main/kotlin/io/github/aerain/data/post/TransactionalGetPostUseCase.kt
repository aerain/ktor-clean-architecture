package io.github.aerain.data.post

import io.github.aerain.usecase.post.GetPostUseCase
import io.github.aerain.usecase.post.Post
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

class TransactionalGetPostUseCase: GetPostUseCase() {
    override suspend fun invoke() = newSuspendedTransaction { super.invoke() }
}