package com.mm.bootproja.controller;

import com.mm.bootproja.biz.UserBiz;
import com.mm.bootproja.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
//@Controller//声明这个类是spring项目中的控制器类（相当于Servlet）
//@ResponseBody
@RestController//Controller+ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBiz biz;
    @RequestMapping("/register")
//    @ResponseBody//当前方法返回Json结构的数据
    public Map register(User user){
        System.out.println(user);
        System.out.println("i receive");
        Map map = new HashMap();
        map.put("isOk",true);
        map.put("msg","注册成功");
        return map;
    }
    @RequestMapping("/login")
//  @ResponseBody//当前方法返回Json结构的数据
    public Map login(User user, HttpSession session){
        System.out.println("i receive");
        user = biz.checkLogin(user);
        session.setAttribute("login_user",user);
        Object u = session.getAttribute("login_user");
        System.out.println("login user: "+u);
        Map map = new HashMap();
        map.put("isOk",true);
        map.put("user",user);
        map.put("msg","登录成功");
        return map;
    }

    public void setBiz(UserBiz biz) {
        this.biz = biz;
    }
}
