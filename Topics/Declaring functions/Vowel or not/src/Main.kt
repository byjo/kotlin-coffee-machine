// write your function here

fun main() {
    val letter = readLine()!!.first()

    println(isVowel(letter))
}

fun isVowel(letter: Char): Boolean {
    val vowels = listOf('A', 'E', 'I', 'O', 'U')
    if (vowels.contains(letter.uppercaseChar())) {
        return true
    }

    return false
}