//package cn.hug.boot.web.controller;
//
//import cn.hug.boot.api.model.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpSession;
//
///**
// * @author: huangwh
// * @mail huangwh@txtws.com
// * @date: 2019-09-06 17:14
// */
//@Slf4j
//@Controller
//public class DemoController {
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @RequestMapping("/index")
//    public String index() {
//        return "index";
//    }
//
//    @RequestMapping("/logout")
//    public String logout() {
//        Subject subject = SecurityUtils.getSubject();
//        if (subject != null) {
//            subject.logout();
//        }
//
//        return "login";
//    }
//
//    @RequestMapping("/admin")
//    @ResponseBody
//    public String admin() {
//        return "success admin";
//    }
//
//    @RequestMapping("/unauthorize")
//    public String unauthorize() {
//        return "unauthorize";
//    }
//
//    @PostMapping("/loginUser")
//    public String loginUser(@RequestParam("username") String username,
//                            @RequestParam("password") String password,
//                            HttpSession session) {
//        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        Subject subject = SecurityUtils.getSubject();
//
//        try {
//            subject.login(token);
//            User user = (User) subject.getPrincipal();
//            session.setAttribute("user", user);
//
//            return "index";
//        } catch (Exception e) {
//            log.error("验证不通过: {}", e.getMessage());
//            return "login";
//        }
//    }
//}
