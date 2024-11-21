package Kotlin010_CoffeeMachine

fun main(){

    val machineState = CoffeeMachineState()
    val coffeeMachine = CoffeeMachine(machineState)

    var lock = true

    while(lock){
        coffeeMachine.displayMenu()
        when(readLine()!!){
            "buy" -> coffeeMachine.buyCoffee()
            "fill" -> coffeeMachine.fillMachine()
            "take" -> coffeeMachine.takeMoney()
            "remaining" -> coffeeMachine.displayResources()
            "exit" -> lock = false
            else -> println("Invalid option")
        }
    }





}