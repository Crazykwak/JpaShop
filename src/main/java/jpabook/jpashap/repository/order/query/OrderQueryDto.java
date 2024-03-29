package jpabook.jpashap.repository.order.query;

import jpabook.jpashap.entity.Address;
import jpabook.jpashap.entity.OrderStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(of = "orderId")
public class OrderQueryDto {

    private Long orderId;
    private String name;
    private LocalDateTime orderData;
    private OrderStatus orderStatus;
    private Address address;
    private List<OrderItemQueryDto> orderItems;

    public OrderQueryDto(Long orderId, String name, LocalDateTime orderData, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name;
        this.orderData = orderData;
        this.orderStatus = orderStatus;
        this.address = address;
    }


    public OrderQueryDto(Long orderId, String name, LocalDateTime orderData, OrderStatus orderStatus, Address address, List<OrderItemQueryDto> orderItems) {
        this.orderId = orderId;
        this.name = name;
        this.orderData = orderData;
        this.orderStatus = orderStatus;
        this.address = address;
        this.orderItems = orderItems;
    }
}
