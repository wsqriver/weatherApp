package com.tools;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AOPUtils {
    private  final Logger logger = LoggerFactory.getLogger(AOPUtils.class);

    //scan api request in controller
    @Pointcut("execution(* com.*.controller.*.*(..))")
    public void aopMethod(){

    }
    @Around("aopMethod()")
    public Object doApiArround(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        //get className&&methodName
        Signature signature = proceedingJoinPoint.getSignature();
        //request param
        Object arg = args[0];

        Object proceed = null;
        try {
            logger.info("API request:"+signature.getDeclaringTypeName()+"className,methodName:"
                    +signature.getName()+",request param:"+ JSON.toJSONString(arg));
            proceed = proceedingJoinPoint.proceed();
            logger.info("API response:"+signature.getDeclaringTypeName()+"className,methodName:"
                    +signature.getName()+",response param:"+(ResponseUtils)proceed);

        } catch (Throwable e) {
            e.printStackTrace();
        }finally {

        }
        return proceed;
    }
}
