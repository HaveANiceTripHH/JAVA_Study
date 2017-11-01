package com.chentao.MicroMessage.bussiness;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

public class FileHandler {
	//需要压缩的文件的目录
	
	public void zipDemo(String folderPath){
		File file = new File(folderPath);
		
		
		//压缩文件的完整的路径名,注意如果zip文件的母文件夹不存在，那么创建zip文件的时候会抛出系统找不到指定路径的异常，所以，最好检验一下父路径是否存在。  
		String zipPath = "D:\\tmp\\test.zip";
		
		ArrayList<File> temp = new ArrayList<File>();
		if(file.isDirectory()){
			File [] files = file.listFiles();			
			Collections.addAll(temp, files);
		}else{
			Collections.addAll(temp, file);
		}
		
		//设定压缩文件的参数：初始化即可，如果不涉及则默认
		ZipParameters zipParameters = new ZipParameters();
		
		try {
			//创建zipFile，注意如果该zipfile已经存在，那么再往里执行虚拟机貌似会卡死，所以最好在这之前做一下校验或者命名唯一确保不存在同名zip文件。
			ZipFile zipFile = new ZipFile(zipPath);
			zipFile.addFiles(temp, zipParameters);
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * @param path 需要打包的文件或者路径
	 * @return String 是生成的zip文件的全路径
	 */
	public static String zip(String path){
		String seperator = "\\";
		File file = new File(path);		
		String zipFilePath = null;
		ArrayList<File> fileList = new ArrayList<File>();
		if(file.isDirectory()){
			zipFilePath = path+seperator+file.getName()+".zip";
			File [] fileArray = file.listFiles();
			Collections.addAll(fileList, fileArray);
		}else{
			zipFilePath = file.getParent()+seperator+file.getName()+".zip";
			Collections.addAll(fileList, file);
		}
		try {
			ZipFile zipFile = new ZipFile(zipFilePath);
			ZipParameters zipParameters = new ZipParameters();
			zipFile.addFiles(fileList, zipParameters);
		} catch (ZipException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zipFilePath;
		
	}
	
	public static String unZip(String path) throws Exception{
		String folderPath = "D:\\tmp\\extract";				//压缩文件的制定存放位置，该文件夹如果为空，则会自动创建
		ZipFile zipFile = new ZipFile(path);
		zipFile.setFileNameCharset("UTF-8");
		
		
		
		zipFile.extractAll(folderPath);
		return folderPath;
		
	}
}
