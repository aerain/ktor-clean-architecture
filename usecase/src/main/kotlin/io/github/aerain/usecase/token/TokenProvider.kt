package io.github.aerain.usecase.token

interface TokenProvider {
    suspend fun issue(context: Context): IssueResponse
}
