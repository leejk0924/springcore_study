package hello.core.member;

import java.util.HashMap;
import java.util.Map;


public class MemoryMemberRepository implements MemberRepository{
    // 실무에서는 concurrentHashMap 사용해야하지만 예제이기 때문에 그냥 HashMap 사용 (동시성 이슈로 인해)
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
