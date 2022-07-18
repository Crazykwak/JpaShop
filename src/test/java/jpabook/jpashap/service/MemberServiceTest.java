package jpabook.jpashap.service;

import jpabook.jpashap.entity.Member;
import jpabook.jpashap.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long memberId = memberService.join(member);

        //then
        Assertions.assertEquals(memberId, member.getId());

    }

    @Test
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("tim");

        Member member2 = new Member();
        member2.setName("tim");

        //when
        memberService.join(member1);

        //then
        assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class);
    }
}