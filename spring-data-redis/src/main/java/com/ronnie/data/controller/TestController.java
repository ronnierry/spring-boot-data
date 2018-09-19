package com.ronnie.data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/13$ 10:06$
 * @Remark:
 */
@RestController
public class TestController {
    @GetMapping("test")
    public Map test(HttpServletRequest request, HttpServletResponse response){
        ServletContext servletContext = request.getServletContext();
        String realPath = servletContext.getRealPath("web.xml");
        String servletPath = request.getServletPath();
        return null;
    }
}
