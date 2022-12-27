package com.neosoft.myapplication

import kotlin.math.pow

class Lambdas {
    fun main(){
        println(sum(1.0, 2.0))

        var fn: (a: Double, b: Double) -> Double = ::sum
        print(fn(1.0, 2.0))

        val lambda = { x: Int, y: Int -> x + y }

        /*multine labmda*/
        val multilineLabda = {
            println("hello")
            val a = 2 + 3
            "Hello lambda"
        }
        /*single param lambda */
        var ab: (Int) -> Int = { a -> a * a }

        val simplified: (Int) -> Int = { it + it }

        /*higher order function*/
        calculator(2.0, 3.0, ::sum)
        calculator(1.0, 2.0) { a, b -> a + b }
    }

    fun sum(a: Double, b: Double): Double {
        return a + b
    }

    fun calculator(a: Double, b: Double, gn: (Double, Double) -> Double) {
        val result = gn(a, b)
        println(result)
    }

    /*filters collection*/
    /*collection functions*/
    /*map,filetr,for each*/
    var nums = listOf<Int>(1, 2, 3, 4, 5, 6)

    val list = nums.filter { it % 2 != 0 }

    private val ab = nums.map { it * it }


    val listOfUser = listOf(
        User(1, "viraj"),
        User(2, "test")
    )

    val res = listOfUser.filter { it.id == 2 }
    

}
    data class User(val id: Int, val name: String)

    fun String.formattedString(): String {
        return "--------$this------------ "
    }