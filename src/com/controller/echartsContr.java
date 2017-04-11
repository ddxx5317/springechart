package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.github.abel533.echarts.Option;
import com.service.EchartsT;

/**
 * 图表
 */
@Controller
@RequestMapping("/echarts")
public class echartsContr {
	
	EchartsT ech = new EchartsT();
	@RequestMapping("ech")
	public  String ech(HttpServletRequest request,HttpServletResponse response){
		
		Option option = ech.echartTest();
			
	//	request.setAttribute("option", option);
		
		String Test = JSON.toJSONString(option);
		

		request.setAttribute("option", Test);
		
		System.out.println(Test);
		
		return "/ec";
	}
	
	/**
	 * @param res
	 * @return
	 */
	@RequestMapping("/line")
	public String  line(HttpServletRequest res)
	{
		Option option =ech.simpleChart();
		
		String opt = JSON.toJSONString(option);
		res.setAttribute("option", opt);
		return "/ec";
	}
	
	/**
	 * @param res
	 * @return
	 * 扇形
	 */
	@RequestMapping("/pie")
	public String pie(HttpServletRequest res)
	{
		Option option = ech.pieTest();
		String opt =JSON.toJSONString(option);
		
		System.out.println(opt);
		
		res.setAttribute("option", opt);
		return "/ec";
	}
	
	 /**
	 * @return
	 * 多个图标表
	 */
	@RequestMapping("pieTest")
	public String pieTest(HttpServletRequest res)
	 {
		 Option option = ech.pieTest();
		 String opt =JSON.toJSONString(option);
		 
		 res.setAttribute("option", opt);
		 System.out.println(opt);
		 return "/ec";
	 }
	 
	
	/**
	 * @param res
	 * @return
	 * 地图测试
	 */
	@RequestMapping("mapTest")
	public String mapTest(HttpServletRequest res)
	{
		Option option = ech.mapTest();
		String opt = JSON.toJSONString(option);
		res.setAttribute("option", opt);
		System.out.println(opt);
		return "/ec";
	}
	
	/**
	 * @param res
	 * @return
	 * 香港地图
	 */
	@RequestMapping("HKMap")
	public String HKMap(HttpServletRequest res)
	{
		Option option = ech.mapTest2();
		String opt = JSON.toJSONString(option);
		
		res.setAttribute("option", opt);
		System.out.println(opt);
		return "/ec";
	}
	
	/**
	 * @param res
	 * @return
	 * 
	 * 堆栈图
	 */
	@RequestMapping("/stackChart")
	public String stackChart(HttpServletRequest res)
	{
		Option option = ech.stackChart();
		String opt = JSON.toJSONString(option);
		res.setAttribute("option", opt);
		return "/ec";
	}
}
