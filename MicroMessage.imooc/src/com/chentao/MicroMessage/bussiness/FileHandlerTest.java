package com.chentao.MicroMessage.bussiness;

import org.junit.Test;

public class FileHandlerTest {

//	@Test
	public void testZip() {
		FileHandler fileHandler = new FileHandler();
	}
	
	@Test
	public void testUnZip(){
		FileHandler fileHandler = new FileHandler();
		String filePath = fileHandler.zip("D:\\tmp");
		try {
			fileHandler.unZip(filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
