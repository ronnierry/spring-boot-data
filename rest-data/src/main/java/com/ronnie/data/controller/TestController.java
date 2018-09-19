package com.ronnie.data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/19$ 15:14$
 * @Remark:
 */
@RestController
public class TestController {
    @GetMapping("test")
    public String test(HttpServletResponse response) {
        Cookie cookie = new Cookie("auth", "21654631321-631321--2313213");
        cookie.setPath("/test/**");
        response.addCookie(cookie);
        return "test";
    }

    @GetMapping("test02")
    public String test02(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        StringBuilder stringBuilder = new StringBuilder();
        Stream.of(cookies).forEach(
                x -> {
                    stringBuilder.append(x.getValue() + "\n");
                }
        );
        return stringBuilder.toString();
    }
}
