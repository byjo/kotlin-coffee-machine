fun main() {
    val range1From = readln().toInt()
    val range1To = readln().toInt()
    val range2From = readln().toInt()
    val range2To = readln().toInt()
    val value = readln().toInt()

    println(value in range1From..range1To && value in range2From..range2To)
}