package com.cspark.play.fpinkotlin.chapter01

import java.lang.IllegalStateException

class Payment(val creditCard: CreditCard, val amount: Int) {
    // 여러 지급을 하나로 묶기
    fun combine(payment: Payment): Payment =
        if (creditCard == payment.creditCard)
            Payment(creditCard, amount + payment.amount)
        else
            throw IllegalStateException("Cards don't match.")

    // 신용 카드에 따라 지급 그룹화하기
    companion object {
        fun groupByCard(payments: List<Payment>) =
            payments.groupBy { it.creditCard }
                .values
                .map { it.reduce(Payment::combine) }
    }
}
