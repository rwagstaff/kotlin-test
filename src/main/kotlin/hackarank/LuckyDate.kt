package hackarank

val date = "02-08-2024"
val date1 = "01-08-2024"
val date2 = "13-08-2024"
val date3 = "13-11-2125"

fun isLuckyDate(dateStr: String): Boolean {
    var trimmedDate = dateStr
    if (dateStr[0] == '0') {
       trimmedDate = dateStr.replaceFirst("0", "")
    }


    val number = trimmedDate.replace("-", "").toInt()

    return number % 7 == 0 || number % 4 == 0
}

fun main() {
    println(isLuckyDate(date))
    println(isLuckyDate(date1))
    println(isLuckyDate(date2))
    println(isLuckyDate(date3))
}