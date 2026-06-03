package com.myredmm.app.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myredmm.app.data.network.HeaderAnalyzer
import com.myredmm.app.data.network.HttpClientProvider
import com.myredmm.app.data.repository.ScannerRepositoryImpl
import com.myredmm.app.domain.model.Vulnerability
import com.myredmm.app.domain.usecase.AnalyzeHeadersUseCase
import kotlinx.coroutines.launch

class ScannerViewModel : ViewModel() {

    var results by mutableStateOf<List<Vulnerability>>(emptyList())
        private set

    var loading by mutableStateOf(false)
        private set

    private val httpClient = HttpClientProvider.httpClient
    private val headerAnalyzer = HeaderAnalyzer(httpClient)
    private val repository = ScannerRepositoryImpl(headerAnalyzer)
    private val analyzeHeadersUseCase = AnalyzeHeadersUseCase(repository)

    fun scan(url: String) {
        if (url.isEmpty()) return
        
        viewModelScope.launch {
            loading = true
            results = try {
                val fullUrl = if (url.startsWith("http")) url else "https://$url"
                analyzeHeadersUseCase(fullUrl)
            } catch (e: Exception) {
                emptyList()
            }
            loading = false
        }
    }
}
