package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

// proxyMod=ScopedProxyMode.TARGET_CLASS 가 핵심 (적용대상이 인터페이스면 INTERFACES 선택)
// MyLogger의 가짜 프록시 클래스를 만들어두고 HTTP request 와 상관없이 가짜 프록시 클래스를 다른 빈에 미리 주입해 둘 수 있다.

@Component
@Scope(value = "request", proxyMode= ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "] [" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope ben create:"+this);
    }
    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope ben close:"+this);
    }

}
