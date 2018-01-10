package com.power.learn.aspect;

import com.power.datasource.aspect.DataSourceAspect;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DbAspect extends DataSourceAspect {

    @Pointcut("execution(* com.boco.learn.dao.*.*(..))")
    @Override
    protected void datasourceAspect() {
        super.datasourceAspect();
    }
}
