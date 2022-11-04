package liga.medical.personservice.core.aop;

import liga.medical.personservice.core.service.LogService;
import liga.medical.personservice.dto.log.LogDto;
import liga.medical.personservice.dto.security.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@Aspect
@RequiredArgsConstructor
public class AuthAdvice {

    private final LogService logService;

    @Autowired
    private Tracer tracer;

    //@Pointcut("this(org.springframework.security.authentication.AuthenticationManager)")
    @Pointcut("@annotation(liga.medical.personservice.api.annotation.Verify) && args(auth)")
    public void authPointcut(AuthenticationRequest auth) { }

    @AfterReturning("authPointcut(auth)")
    public void afterReturningAuthMethod(AuthenticationRequest auth) {
        String logMes = String.format("Success authentication: user %s",
                auth.getUsername());

        logService.saveLog(() -> new LogDto(
                getTraceId(),
                LocalDateTime.now(),
                "INFO",
                auth.getUsername()
        ));

        log.info(logMes);
    }

    @AfterThrowing("authPointcut(auth)")
    public void afterThrowingAuthMethod(AuthenticationRequest auth) {
        String logMes = String.format("Failed authentication: user %s",
                auth.getUsername());

        logService.saveLog(() -> new LogDto(
                getTraceId(),
                LocalDateTime.now(),
                "ERROR",
                auth.getUsername()
        ));

        log.error(logMes);
    }

    private String getTraceId() {
        Span span = tracer.currentSpan();
        if (span != null) {
            return span.context().traceId();
        }

        return "";
    }

}
