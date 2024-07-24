package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Member member = new Member("kim", 22);

        //when
        Member saveMember = memberRepository.save(member);

        //then
        Member findeMember = memberRepository.findById(saveMember.getId());
        assertThat(findeMember).isEqualTo(saveMember);

    }

    @Test
    void findAll(){
        //given
        Member member1 = new Member("효영", 22);
        Member member2 = new Member("형진", 22);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> members = memberRepository.findAll();

        //then
        assertThat(members.size()).isEqualTo(2);
        assertThat(members).contains(member1, member2);
    }
}
