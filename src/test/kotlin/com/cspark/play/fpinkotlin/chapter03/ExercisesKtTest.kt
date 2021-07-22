package com.cspark.play.fpinkotlin.chapter03

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ExercisesKtTest {

    @Test
    internal fun composeInt() {
        assertEquals(36, square(triple(2))) // 함수 합성이 아니다 

        val squareOfTriple = composeInt(::square, ::triple)
        assertEquals(36, squareOfTriple(2))
    }

    @Test
    internal fun compose() {
        val squareOfTriple = compose(::square, ::triple)
        assertEquals(36, squareOfTriple(2))
    }
}
