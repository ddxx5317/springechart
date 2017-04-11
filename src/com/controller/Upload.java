package com.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 下載數據
 */
@Controller
@RequestMapping("/file")
public class Upload {
	
	
	//通过输入输出流上传
	@RequestMapping("/upload")
	public String upload(@RequestParam("file") CommonsMultipartFile file) throws FileNotFoundException
	{
	//@RequestParam("file") 中的"file"是upload.jsp页面的name="file"
		System.out.println(file.getOriginalFilename());
		if(!file.isEmpty())
		{
			//获得文件的io流
			InputStream input;
			int b=0;
			FileOutputStream os = new FileOutputStream("D:/"+new Date().getTime()+"+"+file.getOriginalFilename());
			try {
				input = file.getInputStream();
				while((b=input.read())!=-1)
				{
					os.write(b);
				}
				os.flush();
				os.close();
				input.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "addSuccess";
	}
	
	//可实现多文件上传
	@RequestMapping("/multiUpload")
	public String multiUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		//创建一个通用的多部分解析器
		CommonsMultipartResolver mRes = new CommonsMultipartResolver(request.getSession().getServletContext());
		//request请求中是否存在符合的编码
		if(mRes.isMultipart(request))
		{
			//将request由HttpServletRequest 转换成MultipartHttpServletRequest
			MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest)request;
			//获得文件名
			Iterator<String> str_fileName = mhsr.getFileNames();
			//迭代上传的所有文件
			while(str_fileName.hasNext()){
				MultipartFile file  = mhsr.getFile(str_fileName.next());
				if(file!=null)
				{
					//设置保存的路径
					String path = "D:/"+"upload"+file.getOriginalFilename();
					//新建本地路径
					File localfile = new File(path);
					file.transferTo(localfile);
				}
			}
		}
		return "addSuccess";
	}

	
	@RequestMapping("toUpload")
	public String toUpload(){
		//return "multiUpload";
	 return "upload";
	}
}
