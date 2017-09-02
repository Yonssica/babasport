package com.babasport.core.tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 自定义Session工具类
 * Created by hwd on 2017/8/28.
 */
public class SessionTool {

    /**
     * 分配sdsessionid(self-defined sessionid)，并将sdsession写入到浏览器的cookie中
     *
     * @param request
     * @param response
     * @return
     */
    public static String getSessionId(HttpServletRequest request, HttpServletResponse response) {
        // 从cookie中取出sdsessionid
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            // 判断cookie中是否有sdsessionid
            for (Cookie cookie : cookies) {
                if ("sdsessionid".equals(cookie.getName())) {
                    // 如果有，直接取出来
                    return cookie.getValue();
                }
            }
        }

        // 如果没有sdsessionid，则重新为浏览器创建一个
        String sdsessionid = UUID.randomUUID().toString().replaceAll("-", "");
        System.out.println("创建新的sdsessionid：" + sdsessionid);
        Cookie cookie = new Cookie("sdsessionid", sdsessionid);
        // 设置cookie存活时间
        cookie.setMaxAge(-1);
        // 设置路径
        cookie.setPath("/");
        // 设置二级跨域，由于本次课程中都是localhost，所有无需设置，但是项目正式上限后需要设置该项
        // cookie.setDomain(".babasport.com");
        // 把cookie写会浏览器客户端
        response.addCookie(cookie);
        return sdsessionid;
    }

}
