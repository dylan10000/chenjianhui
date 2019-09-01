package com.bjsxt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
	
	/**
	 * 添加用户
	 */
	@RequestMapping("/addUser")
	public String addUser(Users users){
		this.usersService.addUser(users);
		return "ok";
	}

	@RequestMapping("/findUserAll")
	public String showUsers(Model model){
		List<Users> list = this.usersService.findUserAll();
		model.addAttribute("list", list);
		return "showUsers";
	}
}
