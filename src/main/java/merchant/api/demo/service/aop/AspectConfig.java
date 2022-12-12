package merchant.api.demo.service.aop;

import merchant.api.demo.service.custom.exceptions.MerchantException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Configuration
public class AspectConfig {
    private Logger log = LoggerFactory.getLogger(AspectConfig.class);

    @Before(value = "execution (* merchant.api.demo.service.controllers.*.*(..))")
    public void auditBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("Audit started for {} with following arguments {}", joinPoint, args);
    }

    @After(value = "execution (* merchant.api.demo.service.controllers.*.*(..))")
    public void auditAfter(JoinPoint joinPoint) {
        log.info("Audit ended for {}", joinPoint);
    }

    @Around(value = "execution (* merchant.api.demo.service.services.*.*(..))")
    public Object handleFailures(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return (Object)joinPoint.proceed();
        } catch(MerchantException e) {
            log.info(" Exception occurred. statusCode {} message {}", e.getHttpStatus().value(), e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }
    }
}
