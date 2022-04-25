package machine

fun main() {
    println("The coffee machine has:")
    val gradients = arrayListOf<Gradients>(
        Gradients(Type.WATER, 400),
        Gradients(Type.MILK, 540),
        Gradients(Type.COFFEE_BEANS, 120),
    )
    val coffeeMachine = CoffeeMachine(gradients, 9, 550)
    printCoffeeMachineStatus(coffeeMachine)

    println("Write action (buy, fill, take):")
    val action = readln().toInt()

    println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
    val menu = readln().toInt()
    printCoffeeMachineStatus(coffeeMachine)

}

fun printCoffeeMachineStatus(coffeeMachine: CoffeeMachine) {

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

class CoffeeMachine(private val gradients: List<Gradients>, private val cups: Int, private val money: Int) {
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


