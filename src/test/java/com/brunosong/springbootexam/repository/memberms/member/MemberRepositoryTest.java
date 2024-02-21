package com.brunosong.springbootexam.repository.memberms.member;

import com.brunosong.springbootexam.entity.member.Member;
import com.brunosong.springbootexam.repository.memberms.member.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    @Transactional
    public void memberSaveTest() {
        Member brunoSong = Member.builder()
                .memberName("BrunoSong")
                .build();

        Member member = repository.save(brunoSong);
        Assertions.assertNotNull(member.getMemberId());
    }


}