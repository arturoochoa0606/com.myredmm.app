package com.myredmm.app.data.repository

import com.myredmm.app.data.network.HeaderAnalyzer
import com.myredmm.app.domain.model.Vulnerability

class ScannerRepositoryImpl(
    private val headerAnalyzer: HeaderAnalyzer
) : ScannerRepository {

    override suspend fun analyze(url: String): List<Vulnerability> {
        return headerAnalyzer.analyzeHeaders(url)
    }
}
