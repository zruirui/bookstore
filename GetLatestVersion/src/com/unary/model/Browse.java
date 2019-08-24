package com.unary.model;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class Browse {

	ArrayList<String> modulesPathList = new ArrayList<String>();
	private static Logger logger = Logger.getLogger(Browse.class);
	
	//列出源路径下的 所有目录
	public ArrayList<String> listDir(String sourcePath) {
		File sourceFolder = new File(sourcePath);
		if(sourceFolder.isDirectory()) {
			File[] dirs = sourceFolder.listFiles();
			for(File directory:dirs) {
				modulesPathList.add(directory.getAbsolutePath());				
			}
		}
		else {
			logger.error("源路径"+sourcePath+"不是个文件夹，选择错误！");
		}
		return modulesPathList;
	}
}
