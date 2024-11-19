package Kotlin010_CoffeeMachine

enum class CoffeeType(val water: Int, val milk: Int = 0, val coffeeBeans: Int, val cost: Int){

    ESPRESSO(water = 250, coffeeBeans = 16, cost = 4),
    ESPRESSO_WITH_MILK(water = 250, milk = 50, coffeeBeans = 16, cost = 6),
    LATTE(water = 350, milk = 75, coffeeBeans = 20, cost = 7),
    CAPPUCCINO(water = 200, milk = 100, coffeeBeans = 12, cost = 6)

}