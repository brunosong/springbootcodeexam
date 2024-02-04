package com.brunosong.springbootexam.repository.order;

import com.brunosong.springbootexam.entity.member.Member;
import com.brunosong.springbootexam.entity.order.Order;
import com.brunosong.springbootexam.repository.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class OrderRepositoryTest {

    @Autowired
    OrderRepository repository;

    @Test
    public void orderSaveTest() {
        Order orderItem = Order.builder()
                .memberId(1L)
                .itemName("샴푸")
                .build();

        Order order = repository.save(orderItem);
        Assertions.assertNotNull(order.getOrderId());
    }

}