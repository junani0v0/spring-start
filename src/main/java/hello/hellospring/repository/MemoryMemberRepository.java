package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //0,1,2 key값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);   //id setting
        store.put(member.getId(), member); //store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  //id값으로 찾음
        //null 일 수도 있으니 Optional.ofNullable로 감싸 반환
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()  //store를 루프를 돌림
                .filter(member -> member.getName().equals(name))
                //getName이 파라미터 name하고 같은지 확인
                .findAny(); //같은걸 찾으면 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
