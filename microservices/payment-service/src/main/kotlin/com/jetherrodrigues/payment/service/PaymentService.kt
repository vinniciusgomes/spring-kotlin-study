package com.jetherrodrigues.payment.service

import com.jetherrodrigues.payment.domain.Payment
import com.jetherrodrigues.payment.repository.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(private val repository: PaymentRepository) {

    fun save(payment: Payment): Payment = repository.save(payment)

    fun findAll(): List<Payment> = repository.findAll()

}