package com.jetherrodrigues.payment.domain

import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Payment(
        @Id
        val paymentId: Long = 0,
        val orderId: Long,
        val paymentAuth: String = UUID.randomUUID().toString(),
        val created: LocalDateTime = LocalDateTime.now()
)