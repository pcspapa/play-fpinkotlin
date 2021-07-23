package com.cspark.play.fpinkotlin.chapter03

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ExercisesKtTest {

    @Test
    @DisplayName("함수 합성")
    internal fun composeIntFun() {
        assertEquals(36, square(triple(2))) // 함수 합성이 아니다 

        val squareOfTriple = composeIntFun(::square, ::triple)
        assertEquals(36, squareOfTriple(2))
    }

    @Test
    @DisplayName("함수 재사용하기")
    internal fun composeFun() {
        val squareOfTriple = composeFun(::square, ::triple)
        assertEquals(36, squareOfTriple(2))
    }

    @Test
    @DisplayName("인자가 여럿 있는 함수 처리하기")
    internal fun add() {
        assertEquals(8, add(3)(5))
        assertEquals(8, addTA(3)(5))
    }

    @Test
    @DisplayName("고차 함수")
    internal fun compose() {
        val squareOfTriple = compose(::square)(::triple)
        assertEquals(36, squareOfTriple(2))

        val squareOfTripleTI = composeTI(::square)(::triple)
        assertEquals(36, squareOfTripleTI(2))

        val squareOfTripleTA = composeTA(::square)(::triple)
        assertEquals(36, squareOfTripleTA(2))
    }

    @Test
    @DisplayName("다형적 HOF 정의하기")
    internal fun higherCompose() {
        val squareOfTriple = higherCompose<Int, Int, Int>()(::square)(::triple)
        assertEquals(36, squareOfTriple(2))
    }

    @Test
    @DisplayName("다형적 HOF 정의하기-적용 순서 반대")
    internal fun higherAndThen() {
        val squareOfTriple = higherAndThen<Int, Int, Int>()(::square)(::triple)
        assertEquals(12, squareOfTriple(2))

        val f: (Double) -> Int = { a -> (a * 3).toInt() }
        val g: (Long) -> Double = { a -> a + 2.0 }

        assertEquals(Integer.valueOf(9), f(g(1L)))
        assertEquals(Integer.valueOf(9), higherCompose<Long, Double, Int>()(f)(g)(1L))
        assertEquals(Integer.valueOf(9), higherAndThen<Long, Double, Int>()(g)(f)(1L))
    }
}
