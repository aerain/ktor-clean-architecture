package io.github.aerain.data.config

data class DataSourceProperties(
    val url: String,
    val driver: String,
    val username: String,
    val password: String,
    val connectionPoolSize: Int
)