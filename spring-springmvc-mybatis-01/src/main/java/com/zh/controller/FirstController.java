package com.zh.controller;

import com.zh.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FirstController {

    @RequestMapping("/hello")
    public ModelAndView hello(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // Spring MVC 通过 ModelAndView 对象把模型和视图结合在一起
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello Spring MVC");
        return mav;
    }

    // 表单页面
    @RequestMapping("/form")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mav = new ModelAndView("form");
        return mav;
    }

    // 显示结果页面
    // 原始方式获取请求参数
    @RequestMapping("/result-1")
    public ModelAndView param(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        ModelAndView mav = new ModelAndView("result");
        mav.addObject("userName", userName);
        mav.addObject("password", password);
        return mav;
    }

    // 显示结果页面
    // spring mvc获取请求参数
    @RequestMapping("/result-2")
    public ModelAndView printParam(@RequestParam("userName") String name, @RequestParam("password") String password) {
        ModelAndView mav = new ModelAndView("result");
        mav.addObject("userName", name);
        mav.addObject("password", password);
        return mav;
    }

    // 显示结果页面
    // spring mvc获取请求参数
    @RequestMapping("/result-3")
    public ModelAndView printParam(User user) {
        ModelAndView mav = new ModelAndView("result");
        mav.addObject("userName", user.getName());
        mav.addObject("password", user.getPassword());
        return mav;
    }
}
