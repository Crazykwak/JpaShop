package jpabook.jpashap.repository;

import jpabook.jpashap.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus; // 주문 상태 Order, Cancel

}
