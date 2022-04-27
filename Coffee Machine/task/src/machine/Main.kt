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

    println("Write action (${Action.values().joinToString(", ")}):")
    val action = Action.of(readln())

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

enum class Action(val value: String) {
    BUY("buy"),
    FILL("fill"),
    TAKE("take");

    companion object {
        fun of(value: String): Action {
           return values().first { action -> action.value == value }
        }
    }
}

class Gradients(val type: Type, val quantity: Int) {

}

class Menu(private val name: String, private val gradients: List<Gradients>, private val costs: Int) {
    fun getNeededGradients(count: Int): List<Gradients> {
        return gradients.map { Gradients(it.type, it.quantity * count) }
    }

    fun getMaximumCupsOfCoffee(offeredGradients: List<Gradients>): Int {
        return offeredGradients.minOf { target -> target.quantity / gradients.first { it.type == target.type }.quantity }
    }
}

class CoffeeMachine(private val gradients: List<Gradients>, private val cups: Int, private val money: Int) {
    private val menus = arrayListOf(
        Menu(
            "espresso",
            mutableListOf(
                Gradients(Type.WATER, 250),
                Gradients(Type.COFFEE_BEANS, 16)
            ),
            4
        ),
        Menu(
            "latte",
            mutableListOf(
                Gradients(Type.WATER, 350),
                Gradients(Type.MILK, 75),
                Gradients(Type.COFFEE_BEANS, 20)
            ),
            7
        ),
        Menu(
            "cappuccino",
            mutableListOf(
                Gradients(Type.WATER, 200),
                Gradients(Type.MILK, 100),
                Gradients(Type.COFFEE_BEANS, 12)
            ),
            6
        ),
    )
}


