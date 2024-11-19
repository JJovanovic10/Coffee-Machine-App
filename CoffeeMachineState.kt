package Kotlin010_CoffeeMachine

data class CoffeeMachineState(
    var water: Int = 400,
    var milk: Int = 540,
    var coffeeBeans: Int = 120,
    var cups : Int = 10,
    var money : Int = 550
) {}