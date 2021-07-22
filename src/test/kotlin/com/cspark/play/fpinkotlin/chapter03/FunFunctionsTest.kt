package com.cspark.play.fpinkotlin.chapter03

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.Double.Companion.NEGATIVE_INFINITY
import kotlin.Double.Companion.NaN
import kotlin.Double.Companion.POSITIVE_INFINITY
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

internal class FunFunctionsTest {

    private val funFunctions = FunFunctions()

    @Test
    @DisplayName("순수함수")
    internal fun `pure function`() {
        assertEquals(3, funFunctions.add(1, 2))
        assertEquals(3, funFunctions.add(1, 2))
        assertEquals(0, funFunctions.add(Int.MIN_VALUE, Int.MIN_VALUE))
        assertEquals(-2, funFunctions.add(Int.MAX_VALUE, Int.MAX_VALUE))

        assertEquals(5, funFunctions.mult(1, 2))
        assertEquals(5, funFunctions.mult(3, 4))

        assertEquals(POSITIVE_INFINITY, funFunctions.div(1.0, 0.0))
        assertEquals(NEGATIVE_INFINITY, funFunctions.div(-1.0, 0.0))
        assertEquals(NaN, funFunctions.div(0.0, 0.0))

        assertEquals(109, funFunctions.applyTax2(100))
//        funFunctions.percent2 = 6  compile error
        assertEquals(109, funFunctions.applyTax2(100))

        assertEquals(103, funFunctions.applyTax3(100))
//        funFunctions.percent3 = 6 compile error
        assertEquals(103, funFunctions.applyTax3(100))

        val list = listOf<Int>()
        funFunctions.append2(1, list).size
        assertEquals(0, list.size)
    }

    @Test
    @DisplayName("순수하지 않은 함수")
    internal fun `impure function`() {
        assertFailsWith<ArithmeticException>(
            message = "/ by zero",
            block = { funFunctions.div(1, 0) }
        )

        assertEquals(105, funFunctions.applyTax1(100))
        funFunctions.percent1 = 6
        assertNotEquals(105, funFunctions.applyTax1(100))

        val list = mutableListOf<Int>()
        funFunctions.append(1, list).size
        assertNotEquals(0, list.size)
    }
}
