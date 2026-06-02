object HttpClientProvider {

    val client = HttpClient(CIO) {
        expectSuccess = false
    }

}
