package com.neosoft.myapplication

import kotlin.properties.Delegates

class DelegationsProprties {

    /*lazy observable,vetoable*/
    init {
        print("DelegationsProprties initialised")
    }
}

class Property {
    val heavy by lazy { DelegationsProprties() }

    var marks: Int by Delegates.observable(10) { property, oldValue, newValue ->
        println("oldVale   $oldValue")
        println("newVale   $newValue")

    }

    var age :Int by Delegates.vetoable(14) { property, oldValue, newValue ->

        println("oldAge   $oldValue")
        println("newAge   $newValue")
        newValue >=14
    }
}

fun main() {
    val prooerty = Property()
    prooerty.heavy
    prooerty.marks = 30

    prooerty.age = 20
    prooerty.age =17
}