package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;



@Configuration
@ComponentScan(         // @Component 에너테이션이 붙은 클래스를 자동으로 컨테이너에 등록
        // ComponentScan 하여 스프링빈에 자동등록하는데 그중에 필터링할 클래스 지정
        basePackages="hello.core.member",       // 탐색할 패키지의 시작 위치 지정 (hello.core.member 패키지부터 시작해서 하위패키지 검색)
        basePackageClasses = AutoAppConfig.class,       // AutoAppConfig 클래스의 패키지부터 검색
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)     // Configuration 붙은 에너테이션 제외
        )
public class AutoAppConfig {

    @Bean(name="memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
