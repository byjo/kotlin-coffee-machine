package machine

fun main() {
    val gradients = arrayListOf<Gradients>()
    for (type in Type.values()) {
        println("Write how many ${type.value} of ${type.unit} the coffee machine has:")
        val quantity = readln().toInt()
        gradients.add(Gradients(type, quantity))
    }
    val coffeeMenu = Menu(gradients)

    println("Write how many cups of coffee you will need:")
    val count = readln().toInt()

    if (coffeeMenu.hasEnoughGradients(count)) {
        println("Yes, I can make that amount of coffee")
    } else {
        println("No, I can make only 0 cups of coffee")
    }
}

enum class Type(val value: String, val unit: Unit) {
    WATER("water", Unit.ML),
    MILK("milk", Unit.ML),
    COFFEE_BEANS("coffee beans", Unit.G)
}

enum class Unit(val value: String) {
    ML("ml"),
    G("g")
}

class Gradients(val type: Type, val quantity: Int) {

}

class Menu(val gradients: List<Gradients>) {
    fun getNeededGradients(count: Int): List<Gradients> {
        return gradients.map { Gradients(it.type, it.quantity * count) }
    }

    fun hasEnoughGradients(count: Int): Boolean {
        val neededGradients = getNeededGradients(count)
        return neededGradients.all { gradient -> gradients.first { gradient.type == it.type }.quantity <= gradient.quantity }
    }

}


