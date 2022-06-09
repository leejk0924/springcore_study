package hello.core.scan.filter;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
    // MyIncludeComponent 애너테이션이 붙으면 컴포넌트에 추가한다.
}
