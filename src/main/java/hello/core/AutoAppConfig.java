package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan(         // @Component 에너테이션이 붙은 클래스를 자동으로 컨테이너에 등록
        // ComponentScan 하여 스프링빈에 자동등록하는데 그중에 필터링할 클래스 지정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)     // Configuration 붙은 에너테이션 제외
)


public class AutoAppConfig {


}
