fun main() {
    val value = readln().toInt()
    val from = readln().toInt()
    val to = readln().toInt()

    println(value in from..to)
}