fun main() {
    var location: Int = 0
    var state = "EVEN"
    val tape = arrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 0)
    val rules = mapOf<String, List<() -> Unit>>(
        "EVEN" to listOf(
            { ->
                tape[location] = 1
                kotlin.system.exitProcess(1)
            },
            { ->
                state = "ODD"
                location++
            }
        ),
        "ODD" to listOf(
            { ->
                tape[location] = 0
                kotlin.system.exitProcess(0)
            },
            { ->
                state = "EVEN"
                location++
            }
        )
    )

    while (true) {
        val symbol = tape[location]
        rules[state]!![symbol]()
    }
}