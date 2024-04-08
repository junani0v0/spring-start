package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    //회원이 저장소에 저장
    Optional<Member> findById(Long id);
    //Optional은 findById에서 나오는 null값을 감싸서 처리
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
