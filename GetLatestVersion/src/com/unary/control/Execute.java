package com.unary.control;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.unary.model.Browse;
import com.unary.model.Copy;
import com.unary.model.Filter;
import com.unary.model.GetVersion;

public class Execute {

	private String m_sourcePath = null;
	private String m_destPath = null;
	private ArrayList<String> m_modulePathList = null;
	private ArrayList<String> m_filteredList = null;
	private static Logger logger = Logger.getLogger(Execute.class);
	boolean m_copyResult = false; //拷贝文件成功或者失败标志
	StringBuilder copy_result = new StringBuilder();
	
	public Execute(String sourcePath, String destPath) {
		super();
		this.m_sourcePath = sourcePath;
		this.m_destPath = destPath;
	}
	
	public String operate() {	
		
		Filter filter = new Filter();
		Browse browse = new Browse();
		m_modulePathList = browse.listDir(m_sourcePath);
		m_filteredList = filter.filterDir(m_modulePathList);

		List<String> latestVerList = new GetVersion().listDir(m_filteredList);
		logger.info("所有模块的最新版本路径为：");
		for(String versionPath:latestVerList) {		
			logger.info(versionPath);
		}
		
		Copy copy = new Copy();
		for(String versionPath:latestVerList) {
			File file = new File(versionPath);
			String newPath = m_destPath + File.separator + file.getParentFile().getName() + File.separator + file.getAbsoluteFile().getName();
			m_copyResult = copy.copyDir(versionPath, newPath);
			String moduleName = new File(versionPath).getParentFile().getName();
			if(!m_copyResult) {			
				copy_result.append("模块"+moduleName+"拷贝失败！"+"\n");
			}
			else {
				copy_result.append("模块"+moduleName+"拷贝成功！"+"\n");
			}
		}
		return copy_result.toString();		
		
	}
}
