fun main() {
    val value = readln().toInt()

    val category = when {
        value < 1 -> "no army"
        value in 1..4 -> "few"
        value in 5..9 -> "several"
        value in 10..19 -> "pack"
        value in 20..49 -> "lots"
        value in 50..99 -> "horde"
        value in 100..249 -> "throng"
        value in 250..499 -> "swarm"
        value in 500..999 -> "zounds"
        else -> "legion"
    }

    println(category)
}