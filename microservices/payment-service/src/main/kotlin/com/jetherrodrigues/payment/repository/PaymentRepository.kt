package com.jetherrodrigues.payment.repository

import com.jetherrodrigues.payment.domain.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PaymentRepository : JpaRepository<Payment, Long>