package com.brunosong.springbootexam.repository.member;

import com.brunosong.springbootexam.entity.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class MemberRepositoryTest {

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