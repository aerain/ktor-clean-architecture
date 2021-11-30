package io.github.aerain.api.common

import kotlinx.coroutines.flow.Flow

data class PaginationResponse<T>(
    val page: Long,
    val size: Int,
    val result: List<T>
)