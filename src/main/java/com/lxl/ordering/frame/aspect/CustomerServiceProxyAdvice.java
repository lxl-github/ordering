package com.lxl.ordering.frame.aspect;

import com.lxl.ordering.frame.utils.JsonUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class CustomerServiceProxyAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceProxyAdvice.class);

    @Pointcut("execution(* com.lxl.ordering.business.service..*(..))")
    public void serviceImpl() {
    }

    @Around("serviceImpl()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature =  joinPoint.getSignature();
        Class<?> clazz = ((MethodSignature) signature).getReturnType();

        Object returnVal = null;
        long startTime = System.currentTimeMillis();
        String methodName = joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        String argsJson;
        if (args != null && args.length == 1 && args[0] instanceof String) {
            argsJson = (String) args[0];
        } else {
            argsJson = JsonUtils.toJson(joinPoint.getArgs());
        }
        try {
            if (logger.isInfoEnabled()) {
                logger.info("业务处理方法：{}({})", methodName, argsJson);
            }

            returnVal = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            if((endTime - startTime) > 3000) {
                logger.warn("业务处理方法：" + methodName + "|" + (endTime - startTime));
                logger.warn("业务处理参数：" + argsJson);
            }
        } catch (Exception e) {
            logger.error("系统错误:"+e.getMessage(), e);
            logger.error("业务处理方法：{}({})", methodName, argsJson);
            returnVal = handleException(clazz, e);
        }
        return returnVal;
    }

    private Object handleException(Class<?> clazz, Exception e) {
        Object returnVal = "系统异常!"+e.getMessage();
        return returnVal;
    }
}
