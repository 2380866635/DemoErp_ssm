package com.erp.controller;

import com.erp.mapper.EmpMapper;
import com.erp.mapper.PremissionMapper;
import com.erp.pojo.Emp;
import com.erp.util.TreeResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private PremissionMapper premissionMapper;

    @ResponseBody
    @RequestMapping("login")
    public boolean Login(String username,String password,HttpSession session){
        Emp emp=empMapper.login(username,password);
        if (emp!=null){
            session.setAttribute("user",emp);
            return true;
        }else {
            return  false;
        }
    }
    @ResponseBody
    @RequestMapping("getPerms")
    public List<TreeResultUtil> getPerms(String username){
        System.out.println(premissionMapper.getPerms(username).toString());
        return premissionMapper.getPerms(username);
    }

    @ResponseBody
    @RequestMapping("isLogin")
    public String isLogin(HttpSession session){
        Object user = session.getAttribute("user");
        if (user!=null){
            Emp emp= (Emp) user;
            return emp.getUsername();
        }
        return null;
    }
    @RequestMapping("logout")
    public  String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

}
