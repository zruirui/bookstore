package com.unary.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

public class Copy {
	
	private static Logger logger = Logger.getLogger(Copy.class);
	
	//拷贝目录到本地
	public boolean copyDir(String oldPath, String newPath) {
    	try { 
    		File newfile = new File(newPath); 	
    		if(!newfile.exists()) {
    			boolean mkdirs_result = newfile.mkdirs(); //建立新文件夹 
    			if(mkdirs_result) {
    				logger.info("目标路径文件夹" + newPath + "建立成功"); 
    			}
    			else {
    				logger.info("目标路径文件夹" + newPath + "建立失败"); 
    			}
    		}			
			File a=new File(oldPath); 
			String[] file=a.list(); 
			File temp=null; 
			for (int i = 0; i < file.length; i++) { 
				if(oldPath.endsWith(File.separator)){ 
					temp=new File(oldPath+file[i]); 
				} 
				else{ 
					temp=new File(oldPath+File.separator+file[i]); 
				} 
			
				if(temp.isFile()){ 
					FileInputStream fis = null;
					FileOutputStream fos = null;
					try {
						fis = new FileInputStream(temp); 
						fos = new FileOutputStream(newPath + File.separator + (temp.getName()).toString()); 
						byte[] b = new byte[1024 * 5]; 
						int len; 
						while((len = fis.read(b)) != -1) { 
							fos.write(b, 0, len); 
						} 
						fos.flush(); 
						fos.close();
						fis.close();
						return true;
					}
					catch(IOException e) {
						logger.error(e.getMessage()); 
						e.printStackTrace();
						return false;
					}
								
				} 
				if(temp.isDirectory()){//如果是子文件夹 
					boolean flag = copyDir(oldPath+File.separator+file[i],newPath+File.separator+file[i]); 
					if(flag) {
						return true;
					}
					else {
						return false;
					}
				} 
			}
			return true;
		} 
		catch (Exception e) { 	
			logger.error(e.getMessage()); 
			e.printStackTrace(); 
			return false;
		} 
	}
	
}
