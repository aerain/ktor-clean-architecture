package io.github.aerain.usecase.token

import io.github.aerain.usecase.UseCase

@UseCase
class IssueTokenUseCase(
    private val provider: TokenProvider
) {
    suspend operator fun invoke(context: Context): IssueResponse {
        return provider.issue(context)
    }
}