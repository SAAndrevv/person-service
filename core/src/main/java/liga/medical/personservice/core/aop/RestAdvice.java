package liga.medical.personservice.core.aop;

import liga.medical.commonmodule.utils.ListUtils;
import liga.medical.personservice.core.auth.AuthenticationFacade;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Aspect
public class RestAdvice {

    @Autowired
    private AuthenticationFacade authentication;

    @Pointcut("bean(*Controller)")
    public void restPointcut() { }

    @Before("restPointcut()")
    public void beforeCallRestMethod(JoinPoint jp) {
        String username = authentication.getAuthentication().getName();
        List<?> args = ListUtils.toWildCardList(jp.getArgs());

        String logMes = String.format("Before method calls: %s %s(%s) by user: %s",
                jp.getTarget().getClass().getName(),
                jp.getSignature().getName(),
                (!args.isEmpty()) ? ListUtils.stringListWithoutBrackets(args) : " ",
                username);

        log.info(logMes);
    }

    @AfterReturning("restPointcut()")
    public void afterReturningRestMethod(JoinPoint jp) {
        String username = authentication.getAuthentication().getName();
        List<?> args = ListUtils.toWildCardList(jp.getArgs());

        String logMes = String.format("After a successful call: %s %s(%s) by user: %s",
                jp.getTarget().getClass().getName(),
                jp.getSignature().getName(),
                (!args.isEmpty()) ? ListUtils.stringListWithoutBrackets(args) : " ",
                username);

        log.info(logMes);
    }

    @AfterThrowing(value = "restPointcut()", throwing = "ex")
    public void afterThrowingRestMethod(JoinPoint jp, Exception ex) {
        String username = authentication.getAuthentication().getName();
        List<?> args = ListUtils.toWildCardList(jp.getArgs());

        String logMes = String.format("After a failed call: %s %s(%s) by user: %s. Exception %s",
                jp.getTarget().getClass().getName(),
                jp.getSignature().getName(),
                (!args.isEmpty()) ? ListUtils.stringListWithoutBrackets(args) : " ",
                username,
                ex.toString());

        log.error(logMes);
    }

}
