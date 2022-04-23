fun main() {
    val (val1, operation, val2) = readln().split(" ")
    val first = val1.toLong()
    val second = val2.toLong()

    when (operation) {
        "+" -> println(first + second)
        "-" -> println(first - second)
        "*" -> println(first * second)
        "/" -> if (second == 0L) {
            println("Division by 0!")
        } else {
            println(first / second)
        }
        else -> println("Unknown operator")
    }
}