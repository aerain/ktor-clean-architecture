package io.github.aerain.data

import io.github.aerain.data.config.databaseModule
import io.github.aerain.data.post.postDataModule
import io.github.aerain.data.token.tokenModule

val dataModules = listOf(
    databaseModule,
    postDataModule,
    tokenModule
)