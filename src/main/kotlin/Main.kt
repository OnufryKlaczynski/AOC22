fun main(args: Array<String>) {
    println(maxNumber())
}

private fun maxNumber(): Int {
    return Common.readFileAsLinesUsingGetResourceAsStream("day1.txt")
        .fold(Pair(0, arrayListOf())) { acc: Pair<Int, MutableList<Int>>, value: String ->
            if (value.isBlank()) {
                acc.second.add(acc.first)
                Pair(0, acc.second)
            } else {
                val parseInt = Integer.parseInt(value)
                Pair(acc.first + parseInt, acc.second)
            }

        }.second.sorted().reversed().take(3).sum()
}