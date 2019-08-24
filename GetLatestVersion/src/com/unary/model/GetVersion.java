package com.unary.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class GetVersion {
	
	private static Logger logger = Logger.getLogger(GetVersion.class);
	ArrayList<String> latestVerList = new ArrayList<String>();
	String m_latestVersion;
	//日期正则表达式
	String regex = "^((\\d{2}(([02468][048])|([13579][26]))?((((0?[13578])|(1[02]))?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))?((0?[1-9])|([1-2][0-9])|(30)))|(0?2?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))?((((0?[13578])|(1[02]))?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))?((0?[1-9])|([1-2][0-9])|(30)))|(0?2?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$";
	
	//列出源路径下的所有目录
	public ArrayList<String> listDir(ArrayList<String> modulesPath) {
		for(String modulePath:modulesPath) {
			File moduleFile = new File(modulePath);
			String versionPath = getLatestVersion(moduleFile);
			latestVerList.add(versionPath);
		}
		return latestVerList;
	}
	
	//获取最新版本, 返回路径
	private String getLatestVersion(File moduleFile) {
		String versionPath = null;
		File[] verFiles = moduleFile.listFiles();
		List<String> versionList = new ArrayList<String>();
		for(File verFile:verFiles) {
			String versionName = verFile.getName();
			String date = versionName.substring(0,8);
			if(date.matches(regex)) {
				versionList.add(versionName);
			}					
		}	
		logger.info("模块" + moduleFile.getName() + "下的版本有：");
		for(String version:versionList) {
			logger.info(version);
		}
		if(!versionList.isEmpty()) {
			m_latestVersion = versionList.get(0);
			for(int i = 0; i < versionList.size(); i++) {
	            if(m_latestVersion.substring(0,8).compareTo(versionList.get(i).substring(0,8))<0){
	            	m_latestVersion = versionList.get(i);
	            }
	        }
			logger.info("最新版本为：" + m_latestVersion);
			versionPath = moduleFile.getAbsolutePath() + File.separator + m_latestVersion;
		}
		return versionPath;	

	}
}
