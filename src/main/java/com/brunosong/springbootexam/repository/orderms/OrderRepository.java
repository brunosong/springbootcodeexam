package com.brunosong.springbootexam.repository.orderms;

import com.brunosong.springbootexam.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
