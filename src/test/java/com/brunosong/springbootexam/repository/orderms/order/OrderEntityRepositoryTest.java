package com.brunosong.springbootexam.repository.orderms.order;

import com.brunosong.springbootexam.config.annotation.OrderMsDevDbDataJpaTest;
import com.brunosong.springbootexam.orderms.repository.OrderEntity;
import com.brunosong.springbootexam.orderms.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@OrderMsDevDbDataJpaTest
class OrderEntityRepositoryTest {

    @Autowired
    OrderRepository repository;

    @Test
    public void orderSaveTest() {
        OrderEntity orderEntityItem = OrderEntity.builder()
                .memberId(1L)
                .itemName("샴푸")
                .build();

        OrderEntity orderEntity = repository.save(orderEntityItem);
        Assertions.assertNotNull(orderEntity.getOrderId());
    }

}