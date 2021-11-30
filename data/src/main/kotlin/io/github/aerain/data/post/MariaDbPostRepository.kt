package io.github.aerain.data.post

import io.github.aerain.entity.post.Post
import io.github.aerain.usecase.post.PostRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.*

class MariaDbPostRepository(
    private val dispatcher: CoroutineDispatcher
) : PostRepository {
    override suspend fun findAll(offset: Long, size: Int) = withContext(dispatcher) {
        Posts.selectAll().limit(size, offset)
    }.map { it.toEntity() }

    override suspend fun save(post: Post): Post {
        val result = withContext(dispatcher) {
            Posts.insert {
                it[title] = post.title
                it[author] = post.author
                it[postAt] = post.postAt
            }
        }

        return Post(
            result[Posts.id].value,
            result[Posts.title],
            result[Posts.author],
            result[Posts.postAt]
        )
    }

    override suspend fun update(post: Post): Post {
        withContext(dispatcher) {
            Posts.update({ Posts.id.eq(post.id) }) {
                it[title] = post.title
            }
        }

        return post
    }

    override suspend fun deleteById(id: Long) {
        withContext(dispatcher) {
            Posts.deleteWhere { Posts.id.eq(id) }
        }
    }

    override suspend fun findById(id: Long) = withContext(dispatcher) {
        Posts.select { Posts.id.eq(id) }
    }.singleOrNull()?.toEntity()

    private fun ResultRow.toEntity() = Post(
        this[Posts.id].value,
        this[Posts.title],
        this[Posts.author],
        this[Posts.postAt]
    )

    companion object {
        private const val DEFAULT_PAGE_SIZE = 20
    }
}