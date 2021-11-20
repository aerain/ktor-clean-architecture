package io.github.aerain.post

import java.time.Instant

data class Post(
    val title: String,
    val author: String,
    val postAt: Instant
)