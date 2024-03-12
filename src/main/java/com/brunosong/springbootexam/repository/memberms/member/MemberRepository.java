package com.brunosong.springbootexam.repository.memberms.member;

import com.brunosong.springbootexam.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
