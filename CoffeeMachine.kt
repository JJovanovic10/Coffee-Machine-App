package Kotlin010_CoffeeMachine

import java.lang.Exception

class CoffeeMachine (var state : CoffeeMachineState){


    fun displayMenu(){
        println("Choose an action(buy, fill, take, remaining, exit)")
    }

    // can make coffee -> prepare coffee -> buy coffee

    fun canMakeCoffee(type: CoffeeType): Boolean{
        return when{
            state.water < type.water -> false.also { println("Sorry, not enough water")}
            state.milk < type.milk -> false.also { println("Sorry, not enough milk")}
            state.coffeeBeans < type.coffeeBeans -> false.also { println("Sorry, not enough coffee beans")}
            state.cups < 1 -> false.also { println("Sorry, not enough cups")}
            else -> true
        }
    }

    // prepare coffee -> buy coffee

    fun prepareCoffee(type: CoffeeType){
        try {
            if (canMakeCoffee(type)) {
                state.water -= type.water
                state.milk -= type.milk
                state.coffeeBeans -= type.coffeeBeans
                state.cups -= 1
                state.money += type.cost
                println("I have enough resources, I'm making you a coffee")

                Thread.sleep(3000)

                println("Coffee is ready, you can take it")
            }
        } catch (e : Exception){
            println("Sorry, not enough resources")
        }
    }

    // buy coffee

    fun buyCoffee(){
        println("What do you want to buy? 1 - Espresso, 2 - Espresso with milk, 3 - Latte, 4 - Cappucino, back - return to main menu")
        try {
            when (readLine()!!) {
                "1" -> prepareCoffee(CoffeeType.ESPRESSO)
                "2" -> prepareCoffee(CoffeeType.ESPRESSO_WITH_MILK)
                "3" -> prepareCoffee(CoffeeType.LATTE)
                "4" -> prepareCoffee(CoffeeType.CAPPUCCINO)
                "back" -> return
                else -> println("Invalid option")
            }
        } catch (e: Exception){
            println("Sorry cant make you coffee, try another one")
        }
    }

    // fill machine

    fun fillMachine(){
        try {
            println("Write how many ml of water you want to add:")
            state.water += readLine()!!.toInt()
            println("Write how many ml of milk you want to add:")
            state.milk += readLine()!!.toInt()
            println("Write how many grams of coffee beans you want to add:")
            state.coffeeBeans += readLine()!!.toInt()
            println("Write how many disposable cups you want to add:")
            state.cups += readLine()!!.toInt()
        } catch (e: Exception){
            println("Can't fill coffee machine right now, try later")
        }
    }

    // withdraw money

    fun takeMoney(){
        println("I gave you \$${state.money}")
        state.money = 0
    }

    // display remaining

    fun displayResources(){
        println("""
            The coffee machine has:
            ${state.water} ml of water
            ${state.milk} ml of milk
            ${state.coffeeBeans} g of coffee beans
            ${state.cups} disposable cups
            \$${state.money} of money
            """.trimIndent())
    }

}