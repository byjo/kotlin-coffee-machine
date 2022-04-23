fun main() {
    val dormitory = readln()

    val character = when (dormitory) {
        "gryffindor" -> "bravery"
        "hufflepuff" -> "loyalty"
        "slytherin" -> "cunning"
        "ravenclaw" -> "intellect"
        else -> "not a valid house"
    }

    println(character)
}