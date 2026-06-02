class ScannerViewModel : ViewModel() {

    var results by mutableStateOf<List<Vulnerability>>(emptyList())
        private set

    var loading by mutableStateOf(false)
        private set

    fun scan(url: String) {
        viewModelScope.launch {
            loading = true

            // llamada al caso de uso

            loading = false
        }
    }
}
