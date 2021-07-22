package com.cspark.play.fpinkotlin.chapter03

class Functions {

    fun doubleFun(x: Int): Int = x * 2

    val double: (Int) -> Int = { x -> x * 2 }
    val doubleIt: (Int) -> Int = { it * 2 }

    var add: (Int, Int) -> Int = { x, y -> x + y }

    val multiplyBy2: (Int) -> Int = { n -> double(n) }
    val multiplyBy2It: (Int) -> Int = { double(it) }
    val multiplyBy2Ref: (Int) -> Int = ::doubleFun

    val foo = MyClass()
    val multiplyBy2Val: (Int) -> Int = foo::double

    val multiplyBy2ClassName: (MyClass, Int) -> Int = MyClass::double

    val multiplyBy2Com: (Int) -> Int = (MyClass)::double
}

class MyClass {
    fun double(x: Int): Int = x * 2

    companion object {
        fun double(x: Int): Int = x * 2
    }
}
