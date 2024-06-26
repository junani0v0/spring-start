package hello.hellospring.repository;


import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @Test
    void save() {
        Member member = new Member();
        member.setName("가나다"); //이름 입력

        repository.save(member);//repository에 저장

        Member result = repository.findById(member.getId()).get();//optional에서 값 꺼내올때 .get()사용
//        Assertions.assertEquals(member, result); //result와 member가 같은지 검증
//        Assertions.assertThat(member).isEqualTo(result);

        assertThat(member).isEqualTo(result);
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("가나다라");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("asdf");
        repository.save(member2);

        Member result = repository.findByName("가나다라").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        Member member1 = new Member();
        member1.setName("qwer");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("asdf");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}