package com.cspark.play.fpinkotlin.chapter03

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ConstructorTest {

    @Test
    internal fun `생성자가 순수 함수인가`() {
        val elvis = Person("Elvis")
        val theKing = Person("Elvis")

        assertEquals(elvis, theKing)
    }
}

data class Person(val name: String)
