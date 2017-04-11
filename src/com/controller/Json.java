package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;

/**
 * json格式数据
 */
@Controller
@RequestMapping("/json")
public class Json {

	/**
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 * 将参数传到页面中
	 */
	@RequestMapping("/addUser")
	public String addUser(User user,HttpServletRequest request,HttpServletResponse response)
	{
		
		request.setAttribute("userName",user.getUserName());
		request.setAttribute("pwd",user.getPwd());
		
		return "/addSuccess";
	}
	
	
	
	
	/**
	 * @param user
	 * @param request
	 * @param response
	 * 将参数传到 Ajax中
	 */
	@RequestMapping("/addUserAjax")
	public void addUserAjax(User user,HttpServletRequest request,HttpServletResponse response)
	{
		
		//JSON格式的字符串
		String result="{\"userName\":\" "+user.getUserName()+" \",\"pwd\":\" "+user.getPwd()+"\"}";
		//设置json类型
		response.setContentType("application/json");
		
		PrintWriter out =null;
		try {
			out = response.getWriter();
			//out.write("刘育新");
			//response.getWriter().write(user.getUserName());
			out.print(result);
			
			/********************************************
			 * out = response.getWriter();
			 * out.print(user);//user对象
			 * 在ajax的success中data的不为空，但是data.userName 为空
			 * 
			 */
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	/**
	 * @return
	 * 首页
	 */
	@RequestMapping("mainPage")
	public String mainPage()
	{
		return "/index";
	}
	
}
