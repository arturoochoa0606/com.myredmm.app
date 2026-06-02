@Composable
fun CounterCard(
    label: String,
    count: String
) {
    Card {
        Column {
            Text(label)
            Text(count)
        }
    }
}
