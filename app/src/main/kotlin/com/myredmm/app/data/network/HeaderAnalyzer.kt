package com.myredmm.app.data.network

import com.myredmm.app.domain.model.Severity
import com.myredmm.app.domain.model.Vulnerability
import io.ktor.client.HttpClient
import io.ktor.client.request.head

class HeaderAnalyzer(
    private val httpClient: HttpClient
) {

    suspend fun analyzeHeaders(url: String): List<Vulnerability> {
        return try {
            val response = httpClient.head(url)
            val headers = response.headers.toMap()
            
            val vulnerabilities = mutableListOf<Vulnerability>()
            
            // Check for missing security headers
            if (!headers.containsKey("Strict-Transport-Security")) {
                vulnerabilities.add(
                    Vulnerability(
                        id = "missing_hsts",
                        title = "Missing HSTS Header",
                        description = "HTTP Strict-Transport-Security header is not set",
                        severity = Severity.HIGH
                    )
                )
            }
            
            if (!headers.containsKey("X-Content-Type-Options")) {
                vulnerabilities.add(
                    Vulnerability(
                        id = "missing_xcto",
                        title = "Missing X-Content-Type-Options",
                        description = "X-Content-Type-Options header is not set",
                        severity = Severity.MEDIUM
                    )
                )
            }
            
            if (!headers.containsKey("X-Frame-Options")) {
                vulnerabilities.add(
                    Vulnerability(
                        id = "missing_xfo",
                        title = "Missing X-Frame-Options",
                        description = "X-Frame-Options header is not set",
                        severity = Severity.MEDIUM
                    )
                )
            }
            
            vulnerabilities
        } catch (e: Exception) {
            emptyList()
        }
    }
}
