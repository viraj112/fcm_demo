package com.neosoft.myapplication

import android.renderscript.Sampler.Value
import java.sql.Ref
import kotlin.reflect.KProperty

class DelegationProoerty {
    var firstName: String? by NameDelegate()

    var lastName: String? by NameDelegate()

    override fun toString(): String {
    return "$firstName $lastName"
    }

}

fun main() {
    val property = DelegationProoerty()
    property.firstName = "hello hi  "
    property.lastName ="SKasAS"

    print(property)


}


class NameDelegate() {

    var formattedValue: String? = "null"

    operator fun setValue(
        thisRef: Any?,
        prooerty: KProperty<*>,
        value: String?
    ) {
        if (value != null && value.length > 5) {
            formattedValue = value.toString().toUpperCase()
        }
    }

    operator fun getValue(
        thisRef: Any?,
        prooerty: KProperty<*>
    ): String? {
        return formattedValue
    }
}