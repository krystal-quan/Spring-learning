package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.example.demo")
public class AOPConfig {
    // Displays all the available methods i.e. the advice
    // will be called for all the methods The method
    // declaration is called the pointcut signature. It
    // provides a name that can be used by advice annotations
    // to refer to that pointcut.
    @Pointcut(value = "execution(* com.example.demo.*.*(..))")
    private void selectAll() {}
    // If there is no @Around advice, @Before will be called
    // first, otherwise @Around Before Invocation is called
    @Before("selectAll()")
    public void printLogStatementsBefore() {
        System.out.println(
                ".............Looking for @Around advice, if none is there, @Before will be called first. My role is to execute before each and every method.............");
    }
    // If there is no @Around advice, @After will be called
    // after @Before(if available) first, otherwise @Around
    // After Invocation is called

    @After("selectAll()")
    public void
    printLogStatementsAfter() {
        System.out.println(
                ".............Looking for @Around advice, if none is there, @After will be called after @Before(if available). My role is to execute after each and every method.............");
    }

    // implementing after returning advice
    // This is generally used to indicate the output after
    // successful return of the method, will be called at
    // last i.e. after @Around
    // AOP aspect plug in place is JointPoint
    @AfterReturning(value = "selectAll()", returning = "account")
    public void logsAfterReturningDisplay(JoinPoint joinPoint) {
        System.out.println("After Returning method:" + joinPoint.getSignature());
        // System.out.println(account);
    }

    // implementing after throwing advice
    // This is generally used to indicate the exception in
    // case of exception , will be called whenever exception
    // occurs
    @AfterThrowing(value = "selectAll()", throwing = "ex")
    public void logsAfterThrowingDisplay(JoinPoint jPoint, Exception ex)
    {
        System.out.println("After Throwing exception in method:" + jPoint.getSignature());
        System.out.println("Exception is:" + ex.getMessage());
    }

    // Declares the around advice that is applied before and
    // after the method matching with a pointcut expression
    // Even there are @Before annotations, @Around will be
    // invoked first with the before invocation and then only
    // @Before will be called
    @Around(value = "printAll()")
    public void
    logsAroundAdvice(ProceedingJoinPoint proJoinPoint) throws Throwable {
        System.out.println(
                "The method aroundAdvice() before invocation of the method "
                        + proJoinPoint.getSignature().getName()
                        + " method");
        try {
            proJoinPoint.proceed();
        }
        finally {
        }
        System.out.println(
                "The method aroundAdvice() after invocation of the method "
                        + proJoinPoint.getSignature().getName()
                        + " method");
    }}
