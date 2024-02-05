package com.huang.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.huang.pojo.Result;
import com.huang.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ClassName: CheckInterceptor
 * Description:
 *
 * @Author 小黄
 * @Create 2024/2/2  22:07
 * @Version 1.0
 */
@Slf4j
@Component
public class CheckInterceptor implements HandlerInterceptor {

    @Override//目标资源运行前运行，返回值为true:放行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = request.getHeader("token");
        if(!StringUtils.hasLength(jwt)){
            Result error = Result.error("未登录");
            String s = JSONObject.toJSONString(error);
            response.getWriter().write(s);
            return false;
        }
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败，返回未登录错误信息");
            Result error = Result.error("未登录");
            String s = JSONObject.toJSONString(error);
            response.getWriter().write(s);
            return false;
        }
        return true;
    }

    @Override//目标方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override//视图渲染完毕后运行，最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
