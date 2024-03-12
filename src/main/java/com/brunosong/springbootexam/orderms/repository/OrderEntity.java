package com.brunosong.springbootexam.orderms.repository;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long memberId;

    private String itemName;

    @Builder
    public OrderEntity(Long orderId, Long memberId, String itemName) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.itemName = itemName;
    }

}
