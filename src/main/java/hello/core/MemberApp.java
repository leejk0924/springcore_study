package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        // ApplicationContext : 스프링 컨테이너 (스프링은 해당 예약어로 시작 한다.)
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // applicationContext.getBean("메서드명", 타입); -> 스프링 컨테이너에서 메서드를 찾아오기
        MemberService memberService = applicationContext.getBean("memberService",
            MemberService.class);

        Member member = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("fin dMember = " + findMember.getName());

    }
}
