@Composable
fun DetailBottomSheet(
    vulnerability: Vulnerability
) {
    Column {
        Text(vulnerability.title)
        Text(vulnerability.description)
        Text(vulnerability.impact)
    }
}
