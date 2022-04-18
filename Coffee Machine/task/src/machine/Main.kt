package machine

fun main() {
    val gradients = arrayListOf<Gradients>()
    for (type in Type.values()) {
        println("Write how many ${type.value} of ${type.unit} the coffee machine has:")
        val quantity = readln().toInt()
        gradients.add(Gradients(type, quantity))
    }
    val coffeeMachine = CoffeeMachine(gradients)

    println("Write how many cups of coffee you will need:")
    val neededCount = readln().toInt()

    val maximumCount = coffeeMachine.getMaximumCupsOfCoffee()
    if (maximumCount > neededCount) {
        println("Yes, I can make that amount of coffee (and event ${maximumCount - neededCount} more than that)")
    } else if(maximumCount == neededCount) {
        println("Yes, I can make that amount of coffee")
    } else {
        println("No, I can make only $maximumCount cups of coffee")
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

class Menu(private val gradients: List<Gradients>) {
    fun getNeededGradients(count: Int): List<Gradients> {
        return gradients.map { Gradients(it.type, it.quantity * count) }
    }

    fun getMaximumCupsOfCoffee(offeredGradients: List<Gradients>): Int {
        return offeredGradients.minOf { target -> target.quantity / gradients.first { it.type == target.type }.quantity }
    }
}

class CoffeeMachine(private val gradients: List<Gradients>) {
    private val menu = Menu(
        mutableListOf(
            Gradients(Type.WATER, 200),
            Gradients(Type.MILK, 50),
            Gradients(Type.COFFEE_BEANS, 15)
        )
    )

    fun getMaximumCupsOfCoffee(): Int {
        return menu.getMaximumCupsOfCoffee(gradients)
    }
}


