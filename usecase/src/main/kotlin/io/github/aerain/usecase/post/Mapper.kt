package io.github.aerain.usecase.post

import io.github.aerain.entity.post.Post as PostEntity

fun PostEntity.toDto() = Post(id, title, author, postAt)