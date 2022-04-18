// write your code here

/* Do not change code below */
fun main() {
    val a = readLine()!!.toLong()
    val b = readLine()!!.toLong()
    println(divide(a, b))
}

fun divide(numerator: Long, denominator: Long): Double {
    return numerator.toDouble() / denominator.toDouble()
}
