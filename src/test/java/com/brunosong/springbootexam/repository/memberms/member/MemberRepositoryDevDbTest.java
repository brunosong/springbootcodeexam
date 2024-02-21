package com.brunosong.springbootexam.repository.memberms.member;

import com.brunosong.springbootexam.config.annotation.MemberMsDevDbDataJpaTest;
import com.brunosong.springbootexam.entity.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@MemberMsDevDbDataJpaTest
class MemberRepositoryDevDbTest {

    /* 개발 DB에서 가져오는 데이터를 가지고 테스트를 할 경우도 있으니깐 만들어 둔다. */

    @Autowired
    MemberRepository repository;

    @Test
    public void memberSaveTest() {

        Member brunoSong = Member.builder()
                .memberName("BrunoSong")
                .build();

        Member member = repository.save(brunoSong);
        Assertions.assertNotNull(member.getMemberId());

    }

}