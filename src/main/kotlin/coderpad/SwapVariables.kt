package coderpad

fun swap() {
    var a = 1
    var b = 10

    println("Initial variables $a $b")

    val temp = a
    a = b
    b = temp

    println("Swapped variables $a $b")

}

fun swapArithmetic() {
    var a = 1
    var b = 10
    println("Initial variables $a $b")
    a += b
    b = a - b
    a -= b

    println("Swapped variables $a $b")
}

fun main() {
    swap()
    swapArithmetic()
}