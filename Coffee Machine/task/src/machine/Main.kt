package machine

fun main() {
    println("Write how many cups of coffee you will need:")
    val count = readln().toInt()

    val coffeeMenu = Menu(
        mutableListOf(
            Gradients(Type.WATER, 200, Unit.ML),
            Gradients(Type.MILK, 50, Unit.ML),
            Gradients(Type.COFFEE_BEANS, 15, Unit.G)
        )
    )

    println("For $count cups of coffee you will need:")

    val neededGradients = coffeeMenu.getNeededGradients(count)
    for (gradient in neededGradients) {
        println("${gradient.quantity} ${gradient.unit.value} of ${gradient.type.value}")
    }
}

enum class Type(val value: String) {
    WATER("water"),
    MILK("milk"),
    COFFEE_BEANS("coffee beans")
}

enum class Unit(val value: String) {
    ML("ml"),
    G("g")
}

class Gradients(val type: Type, val quantity: Int, val unit: Unit) {

}

class Menu(val gradients: List<Gradients>) {
    fun getNeededGradients(count: Int): List<Gradients> {
        return gradients.map { Gradients(it.type, it.quantity * count, it.unit) }
    }
}


