package com.cspark.play.fpinkotlin.chapter03

// 함수 합성
fun square(n: Int) = n * n

fun triple(n: Int) = n * 3

fun composeInt(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int =
    { x -> f(g(x)) }

// 함수 재사용하기
fun <T, U, V> compose(f: (U) -> V, g: (T) -> U): (T) -> V =
    { f(g(it)) }
