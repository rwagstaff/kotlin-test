package algo

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.round

val sortedArray = intArrayOf(
    4,
    13,
    20,
    22,
    24,
    31,
    37,
    44,
    67,
    87,
    89,
    105,
    110,
    125,
    143,
    153,
    173,
    184,
    184,
    190,
    192,
    237,
    243,
    246,
    270,
    273,
    278,
    283,
    296,
    301,
    301,
    309,
    315,
    342,
    344,
    348,
    369,
    378,
    387,
    392,
    400,
    401,
    418,
    423,
    424,
    424,
    447,
    497,
    499,
    503,
    507,
    511,
    573,
    596,
    609,
    611,
    617,
    631,
    635,
    636,
    638,
    638,
    651,
    659,
    669,
    682,
    692,
    701,
    702,
    703,
    722,
    732,
    737,
    746,
    752,
    764,
    781,
    785,
    788,
    790,
    799,
    811,
    854,
    854,
    864,
    877,
    878,
    886,
    893,
    903,
    905,
    915,
    928,
    930,
    944,
    963,
    972,
    980
)


fun quickSearch(arr: IntArray, num: Int): Int? {


    var pos: Int = (arr.size) / 2
    var prevPos = arr.size
    var step = 0

    //println("$pos $prevPos")

    while (prevPos != pos) {
        val i = arr[pos]
        val diff = abs(prevPos - pos)
        step = ceil(diff.toDouble() / 2.0).toInt()
        if (i == num) {
            return pos
        } else if (num > i) {
            prevPos = pos
            pos += step
        } else {
            prevPos = pos
            pos -= step
        }

        if (pos >= arr.size) {
            pos = arr.size -1
        }
        else if (pos < 0) {
            pos = 0
        }

        //println("Pos $pos, Prev $prevPos, Step $step, value $i")
    }

    return null


}

fun printRes(num: Int) {
    println("Search ${quickSearch(sortedArray, num)}, Index ${sortedArray.indexOf(num)}")
}

fun main() {
    printRes(854)
    printRes(980)
    printRes(972)
    printRes(692)
    printRes(4)
    printRes(13)
    printRes(10000)
}







