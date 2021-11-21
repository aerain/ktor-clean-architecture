package io.github.aerain.usecase.post

import kotlinx.coroutines.flow.Flow
import io.github.aerain.entity.post.Post

interface PostRepository {
    suspend fun findAll(): Flow<Post>
    suspend fun findById(id: Long): Post
}