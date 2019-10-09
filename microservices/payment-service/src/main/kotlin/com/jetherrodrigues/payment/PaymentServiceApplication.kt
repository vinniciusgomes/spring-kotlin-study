package com.jetherrodrigues.payment

import com.jetherrodrigues.payment.application.config.swaggerBeans
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.ComponentScan
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableSwagger2
@EnableDiscoveryClient
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
class PaymentServiceApplication

fun main(args: Array<String>) {
	runApplication<PaymentServiceApplication>(*args) {
		addInitializers(swaggerBeans())
	}
}

