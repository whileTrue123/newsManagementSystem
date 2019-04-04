package com.zhoujie.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhoujie.model.User;
import com.zhoujie.service.UserService;

/** 
* @author zhoujie
*/
@Controller
public class LoginController {
	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String toRegister(Model model){
        return  "/background/login";
    }
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String Login(@RequestParam("username")String username , @RequestParam("password")String password , 
			HttpServletRequest request , Model model){
		System.out.println("Login");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		User currentUser = userService.userLogin(user);
		HttpSession session=request.getSession();
		if(currentUser == null){
			request.setAttribute("error", "用户名或者密码错误！");
			request.setAttribute("password", password);
			request.setAttribute("username", username);
			return "/background/login";
		}else{
			session.setAttribute("currentUser", currentUser);
			request.setAttribute("mainPage", "/background/default.jsp");
			return "/background/mainTemp";
		}
	}
	
	@RequestMapping(value = "/logout")
	public String Logout(HttpServletRequest request, HttpServletResponse response){
		request.getSession().invalidate();
		//System.out.println(request.getContextPath()+"/background/login.jsp");
		return "redirect:/background/login.jsp";
	}
}
