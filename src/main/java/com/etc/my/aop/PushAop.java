package com.etc.my.aop;

import com.etc.my.service.CarService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: Admin
 * @time: 2022/11/3 14:42
 */

//@Aspect
//@Component
public class PushAop {

    @Autowired
    private CarService carService;
    //切入函数
    @Pointcut("execution(* com.etc.my.service.impl.CarServiceImpl.addCarAndPic(..))")
    private void MyPushCar(){}


    @Around("MyPushCar()")
    public boolean pushCar(ProceedingJoinPoint point) throws Throwable {
        Object[] carAndPic = point.getArgs();
        boolean addcarflag = (boolean) point.proceed();
        if((addcarflag)){
            return false;
        }
        return false;
    }

}
