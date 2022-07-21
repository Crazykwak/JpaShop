package jpabook.jpashap.service;

import jpabook.jpashap.entity.Delivery;
import jpabook.jpashap.entity.Member;
import jpabook.jpashap.entity.Order;
import jpabook.jpashap.entity.OrderItem;
import jpabook.jpashap.entity.item.Item;
import jpabook.jpashap.repository.ItemRepository;
import jpabook.jpashap.repository.MemberRepository;
import jpabook.jpashap.repository.OrderRepository;
import jpabook.jpashap.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    //주문
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        Member findMember = memberRepository.findOne(memberId);
        Item findItem = itemRepository.findOne(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(findMember.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(findItem, findItem.getPrice(), count);

        Order order = Order.createOrder(findMember, delivery, orderItem);
        orderRepository.save(order);

        return order.getId();
    }

    //취소
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }

    //검색
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByCriteria(orderSearch);
    }
}
