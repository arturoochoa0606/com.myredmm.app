class HeaderAnalyzer {

    fun analyze(headers: Headers): List<Vulnerability> {

        val result = mutableListOf<Vulnerability>()

        if (!headers.contains("Content-Security-Policy")) {
            result.add(
                Vulnerability(
                    "HDR-001",
                    "CSP ausente",
                    Severity.P2,
                    "...",
                    "...",
                    "Agregar Content-Security-Policy"
                )
            )
        }

        return result
    }
}
