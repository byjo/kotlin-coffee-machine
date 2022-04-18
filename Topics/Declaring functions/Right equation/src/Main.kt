// write your code here

/* Do not change code below */
fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    println(isRightEquation(a, b, c))
}

fun isRightEquation(first: Int, second: Int, third: Int): Boolean {
    return first * second == third
}
