package com.chentao.MicroMessage.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chentao.MicroMessage.bussiness.FileHandler;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String path = FileHandler.zip("D:\\tmp");
		File file = new File(path);
		
		InputStream is = new FileInputStream(file);
		String fileName = path.substring(path.lastIndexOf('\\')-1);
		
		resp.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		
		OutputStream out = resp.getOutputStream();
		
		byte [] buffer = new byte[1024];
		
		int len = 0;
		while((len=is.read(buffer))>0){
			out.write(buffer,0,len);
		}
		is.close();
		out.close();
	}
}
