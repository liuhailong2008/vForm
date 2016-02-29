package cn.dragonberg.spark.core.adapter;

import java.util.Map;

/**
 * 
 * @author liuhailong<liuhailong2008#foxmail.com>
 */
public interface SparkAdapter {

	public String getParameter(Object in, String name) ;
		
	public String getConfigId(Object in);
	
	public String getMethod(Object in);
	
	public Map<String,String> getParameters(Object in);
	
	public String beforeOutput(String ret);
}
