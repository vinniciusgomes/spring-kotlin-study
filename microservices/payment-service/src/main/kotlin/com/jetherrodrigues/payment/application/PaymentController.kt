package com.jetherrodrigues.payment.application

import com.jetherrodrigues.payment.application.request.PaymentRequest
import com.jetherrodrigues.payment.service.PaymentService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/payments")
class PaymentController(private val service: PaymentService) {

    @PostMapping
    fun create(@RequestBody @Valid request: PaymentRequest) =
            request
                    .let(PaymentRequest::toPayment)
                    .run {
                        service.save(this)
                    }

    @GetMapping
    fun list() = service.findAll()

}