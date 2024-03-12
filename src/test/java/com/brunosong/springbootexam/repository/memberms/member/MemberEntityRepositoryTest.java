package com.brunosong.springbootexam.repository.memberms.member;

import com.brunosong.springbootexam.memberms.repository.MemberEntity;
import com.brunosong.springbootexam.memberms.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest
class MemberEntityRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    @Transactional
    public void memberSaveTest() {
        MemberEntity brunoSong = MemberEntity.builder()
                .memberName("BrunoSong")
                .build();

        MemberEntity memberEntity = repository.save(brunoSong);
        Assertions.assertNotNull(memberEntity.getMemberId());
    }


}