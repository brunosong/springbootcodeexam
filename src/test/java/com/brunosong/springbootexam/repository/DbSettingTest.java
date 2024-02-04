package com.brunosong.springbootexam.repository;

import com.brunosong.springbootexam.entity.member.Member;
import com.brunosong.springbootexam.entity.order.Order;
import com.brunosong.springbootexam.repository.member.MemberRepository;
import com.brunosong.springbootexam.repository.order.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DbSettingTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void multiDbSaveTest() {
        Member brunoSong = Member.builder()
                .memberName("BrunoSong")
                .build();

        Member member = memberRepository.save(brunoSong);
        Assertions.assertNotNull(member.getMemberId());

        Order orderItem = Order.builder()
                .memberId(1L)
                .itemName("샴푸")
                .build();

        Order order = orderRepository.save(orderItem);
        Assertions.assertNotNull(order.getOrderId());


    }


}
