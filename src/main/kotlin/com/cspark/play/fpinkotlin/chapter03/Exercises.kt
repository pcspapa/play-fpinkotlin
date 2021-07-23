package com.cspark.play.fpinkotlin.chapter03

// 함수 합성
fun square(n: Int) = n * n
fun triple(n: Int) = n * 3

fun composeIntFun(f: (Int) -> Int, g: (Int) -> Int): (Int) -> Int = { x -> f(g(x)) }

// 함수 재사용하기
fun <T, U, V> composeFun(f: (U) -> V, g: (T) -> U): (T) -> V = { f(g(it)) }

// 인자가 여럿 있는 함수 처리하기
val add: (Int) -> (Int) -> Int = { a -> { b -> a + b } }

typealias IntBinOp = (Int) -> (Int) -> Int

val addTA: IntBinOp = { a -> { b -> a + b } }
val multTA: IntBinOp = { a -> { b -> a * b } }

// 고차 함수
val compose: ((Int) -> Int) -> ((Int) -> Int) -> (Int) -> Int = { x -> { y -> { z -> x(y(z)) } } }

val composeTI = { x: (Int) -> Int ->
    { y: (Int) -> Int ->
        { z: Int ->
            x(y(z))
        }
    }
} // 타입추론(Type inference)

typealias IntUnaryOp = (Int) -> Int

val composeTA: (IntUnaryOp) -> (IntUnaryOp) -> IntUnaryOp = { x -> { y -> { z -> x(y(z)) } } }

// 다형적 HOF 정의하기
/* 코틀린에서는 다형적 프로퍼티를 정의할 수 없다.
val <T, U, V> higherCompose: ((U) -> V) -> ((T) -> U) -> (T) -> V = { f ->
    { g ->
        { x ->
            f(g(x))
        }
    }
}
*/

fun <T, U, V> higherCompose() =
    { f: (U) -> V ->
        { g: (T) -> U ->
            { x: T ->
                f(g(x))
            }
        }
    }
/*
fun <T, U, V> higherCompose(): ((U) -> V) -> ((T) -> U) -> (T) -> V = { f -> { g -> { x -> f(g(x)) } } }
*/

fun <T, U, V> higherAndThen(): ((T) -> U) -> ((U) -> V) -> (T) -> V =
    { f: (T) -> U ->
        { g: (U) -> V ->
            { x: T ->
                g(f(x))
            }
        }
    }

// 함수 부분 적용가 자동 커링
fun <A, B, C> partialA(a: A, f: (A) -> (B) -> C): (B) -> C = f(a) // TODO

fun <A, B, C> partialB(b: B, f: (A) -> (B) -> C): (A) -> C = { a: A -> f(a)(b) } // TODO

fun <A, B, C, D> curried() =
    { a: A ->
        { b: B ->
            { c: C ->
                { d: D ->
                    "$a $b $c $d"
                }
            }
        }
    }

fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
    { a ->
        { b ->
            f(a, b)
        }
    }

fun <T, U, V> swapArgs(f: (T) -> (U) -> V): (U) -> (T) -> V =
    { u ->
        { t ->
            f(t)(u)
        }
    }
