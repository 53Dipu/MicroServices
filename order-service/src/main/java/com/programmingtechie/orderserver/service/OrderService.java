package com.programmingtechie.orderserver.service;

import com.programmingtechie.orderserver.dto.OrderLineItemsDto;
import com.programmingtechie.orderserver.dto.OrderRequest;
import com.programmingtechie.orderserver.model.Order;
import com.programmingtechie.orderserver.model.OrderlineItems;
import com.programmingtechie.orderserver.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        
       List<OrderlineItems> orderlineItems =  orderRequest.getOrderLineItemsDtoList()
                .stream().
                map(this::mapToDto)
                .toList();

        order.setOrderlineItemsList(orderlineItems);
        orderRepository.save(order);
    }

    private OrderlineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderlineItems orderlineItems = new OrderlineItems();
        orderlineItems.setPrice(orderLineItemsDto.getPrice());
        orderlineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderlineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderlineItems;
    }

    public OrderRequest getAllOrders(OrderLineItemsDto orderLineItemsDto){
      OrderlineItems orderlineItems = new OrderlineItems();
       orderlineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        orderlineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderlineItems.setPrice(orderLineItemsDto.getPrice());
        return new OrderRequest();

    }
}
