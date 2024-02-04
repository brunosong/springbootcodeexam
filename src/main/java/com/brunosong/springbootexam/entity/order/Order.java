package com.brunosong.springbootexam.entity.order;


import com.brunosong.springbootexam.entity.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long memberId;

    private String itemName;

    @Builder
    public Order(Long orderId, Long memberId, String itemName) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.itemName = itemName;
    }

}
