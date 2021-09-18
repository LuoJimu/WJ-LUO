package com.evan.sanhei.common.interceptor;

import io.netty.handler.codec.http.HttpMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: WJ-LUO
 * @description: Interceptor 即拦截器，在 Springboot 我们可以直接继承拦截器的接口，然后实现 preHandle 方法。preHandle 方法里的代码会在访问需要拦截的页面时执行
 * @author: Jimu.Luo
 * @create: 2021-09-15 09:52
 **/

public class LoginInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        // 放行 options 请求，否则无法让前端带上自定义的 header 信息，导致 sessionID 改变，shiro 验证失败
        if (HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        Subject subject = SecurityUtils.getSubject();
        // 使用 shiro 验证，两种状态都放行
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            return false;
        }
        return true;

    }

    private boolean begingWith(String page, String[] requiredAuthPages) {
        boolean result = false;
        for (String requiredAuthPage : requiredAuthPages) {
            if(StringUtils.startsWith(page, requiredAuthPage)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
