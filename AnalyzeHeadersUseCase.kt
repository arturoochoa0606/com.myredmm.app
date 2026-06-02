class AnalyzeHeadersUseCase(
    private val repository: ScannerRepository
) {

    suspend operator fun invoke(
        url: String
    ): List<Vulnerability> {

        return repository.analyze(url)
    }
}
