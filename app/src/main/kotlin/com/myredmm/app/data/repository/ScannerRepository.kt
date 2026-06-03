package com.myredmm.app.data.repository

import com.myredmm.app.domain.model.Vulnerability

interface ScannerRepository {
    suspend fun analyze(url: String): List<Vulnerability>
}
