package com.nexwise.utils.aop;

import com.nexwise.entity.LoginLog;
import com.nexwise.entity.Users;
import com.nexwise.service.LoginLogService;
import com.nexwise.utils.IPUtils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Descript aop登录日志
 * @Author fuyuanming
 * @Date 2018-05-11 10:04:55
 * @Version 1.0
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private LoginLogService loginLogService;

    //登录方法切入
    @Pointcut("execution(public * com.nexwise.controller.LoginController.loginMethod(..))")
    public void loginLog() {

    }

    @Around("loginLog()")
    public Object loginAround(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        System.out.println("执行登录操作");
        return result;
    }

    /**
     * 登录成功后记录日志
     * @param joinPoint
     */
    @AfterReturning("loginLog()")
    public void loginAfter(JoinPoint joinPoint) {
        Object[] objects  = joinPoint.getArgs();
        if (objects.length > 0) {
            System.out.println("登录成功！");
            long start = System.currentTimeMillis();
            long spendTime = System.currentTimeMillis() - start;
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            //浏览器信息
            Browser browser = userAgent.getBrowser();
            Users user = (Users) SecurityUtils.getSubject().getPrincipal();
            LoginLog loginLog = new LoginLog();
            loginLog.setLoginName("xiaoming");
            loginLog.setIp(IPUtils.getClinetIp(request));
            loginLog.setLoginTime(new Date());
            loginLog.setLoginStatus(1);
            loginLog.setSpendTime(spendTime);
            loginLog.setBrowserName(browser.getName());
            loginLog.setBrowserType(browser.getBrowserType().getName());
            loginLog.setBrowserVersion(userAgent.getBrowserVersion().getVersion());
            loginLog.setOperationSystem(userAgent.getOperatingSystem().getName());
            //保存登录日志
            loginLogService.insert(loginLog);
        }
    }



}
