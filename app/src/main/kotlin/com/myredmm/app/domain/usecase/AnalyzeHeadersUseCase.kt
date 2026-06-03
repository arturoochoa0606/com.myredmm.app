package com.myredmm.app.domain.usecase

import com.myredmm.app.data.repository.ScannerRepository
import com.myredmm.app.domain.model.Vulnerability

class AnalyzeHeadersUseCase(
    private val repository: ScannerRepository
) {

    suspend operator fun invoke(
        url: String
    ): List<Vulnerability> {
        return repository.analyze(url)
    }
}
