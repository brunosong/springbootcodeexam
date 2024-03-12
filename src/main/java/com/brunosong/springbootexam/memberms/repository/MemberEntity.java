package com.brunosong.springbootexam.memberms.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String memberName;

    @Builder
    public MemberEntity(Long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
