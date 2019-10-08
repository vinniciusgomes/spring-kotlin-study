package com.jetherrodrigues.unisal.application.web;

import com.jetherrodrigues.unisal.application.web.request.OrderRequest;
import com.jetherrodrigues.unisal.application.web.response.OrderResponse;
import com.jetherrodrigues.unisal.domain.order.Order;
import com.jetherrodrigues.unisal.domain.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> create(@RequestBody @Valid final OrderRequest request,
                                    final UriComponentsBuilder uriBuilder) {

        final Order created = orderService.save(OrderRequest.toOrder(request));

        URI uri = uriBuilder.path("/orders/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(OrderResponse.from(created));
    }

}
