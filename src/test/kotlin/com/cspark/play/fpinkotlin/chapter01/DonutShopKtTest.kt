package com.cspark.play.fpinkotlin.chapter01

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DonutShopKtTest {

    @Test
    internal fun buyDonuts() {
        val creditCard = CreditCard()
        val purchase = buyDonuts(5, creditCard)
        assertEquals(Donut.price * 5, purchase.payment.amount)
        assertEquals(creditCard, purchase.payment.creditCard)
    }
}
