package com.programmingtechie.orderserver.controller;

import com.programmingtechie.orderserver.dto.OrderLineItemsDto;
import com.programmingtechie.orderserver.dto.OrderRequest;
import com.programmingtechie.orderserver.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor

public class OrderController {

    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){

        orderService.placeOrder(orderRequest);

        return "Order Placed Successfully";
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
   public OrderRequest getAllOrders(@RequestParam(name = "orderLineItemsDtoList") OrderLineItemsDto orderLineItemsDto){
        return orderService.getAllOrders(orderLineItemsDto);

    }

}
