package com.chentao.MicroMessage.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.chentao.MicroMessage.bussiness.FileHandler;

@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		if(null==method || "".equals(method)){
			req.getRequestDispatcher("/WEB-INF/jsp/uploadDemo.jsp").forward(req, resp);
		}
		else if("submit".equals(method)){
			try {
				String filePath = upload(req, resp);
				FileHandler.unZip(filePath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
	public String upload(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		
		servletFileUpload.setHeaderEncoding("UTF-8");
		
		File temp = new File("D:\\temp");
		
		diskFileItemFactory.setSizeThreshold(1024*500);
		diskFileItemFactory.setRepository(temp);
		servletFileUpload.setFileSizeMax(1024*1024*10);
		
		List<FileItem> items= servletFileUpload.parseRequest(req);
		
		OutputStream out = null;
		InputStream in = null;
		String filePath = null;
		
		for (FileItem item:items){
			if(item.isFormField()){
				String name = item.getFieldName();
				String value = item.getString();
				
				System.out.println("name: "+name+"\tvalue: "+value);
			}else{
				String fileName = item.getName();
				long sizeInBytes = item.getSize();
				
				System.out.println(fileName);
				System.out.println(sizeInBytes);
				
				in = item.getInputStream();
				byte [] buffer = new byte[1024];
				int len = 0;
				
				String folderPath = "D:\\tmp\\upload";
				File file = new File(folderPath);
				if(!file.exists()){
					file.mkdirs();
				}
				
				filePath = folderPath + "\\" + item.getName();
				File uploadFile = new File(filePath);
				
				out = new FileOutputStream(uploadFile);
				
				while((len=in.read(buffer)) != -1){
					out.write(buffer);
				}
				
			}			
		}
		if(in!=null){
			in.close();
		}
		if(out !=null){
			
			out.close();
		}
		
		return filePath;
		
		
		
	}
}
