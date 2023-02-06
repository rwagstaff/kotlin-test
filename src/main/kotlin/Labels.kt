fun main() {
    breakAndContinueLabels()
    returnLabels();
}

fun breakAndContinueLabels() {
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 50) {
                println(j + 1)
                break@loop // Break the outer loop
            }
        }
    }
}

fun returnLabels() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    print(" done with explicit label") // This code is unreachable without label
}
