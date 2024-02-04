package com.brunosong.springbootexam.repository.member;

import com.brunosong.springbootexam.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
