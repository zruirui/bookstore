package com.unary.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Filter {
	
	ArrayList<String> m_filterList = new ArrayList<String>();
	private static Logger logger = Logger.getLogger(Filter.class);
	
	//过滤掉在配置文件中的模块名
	//返回过滤后的模块路径列表
	public ArrayList<String> filterDir(ArrayList<String> modulesPathList) {
		try {   
			File f = new File("src/filterDir.xml");   
			SAXReader reader = new SAXReader();   
			Document doc = reader.read(f);   
			Element root = doc.getRootElement();   
			Element foo;   
			for (Iterator i = root.elementIterator("value"); i.hasNext();) {   
				foo = (Element) i.next();   
				String dirName = foo.elementText("dir");
				m_filterList.add(dirName);  
			}
			Iterator it = modulesPathList.iterator();
			while(it.hasNext()) {
				String path = (String) it.next();
				String name = new File(path).getName();
				if(m_filterList.contains(name)) {
					it.remove();
				}
			}
		} 
		catch (Exception e) { 
			logger.error(e.getMessage());
			e.printStackTrace();   
		} 
		return modulesPathList;
	}
}
