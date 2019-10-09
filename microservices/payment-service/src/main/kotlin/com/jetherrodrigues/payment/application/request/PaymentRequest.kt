package com.jetherrodrigues.payment.application.request

import com.jetherrodrigues.payment.domain.Payment
import javax.validation.constraints.NotNull

data class PaymentRequest(
        @field:NotNull val orderId: Long
) {
    fun toPayment() = Payment(orderId = orderId)
}