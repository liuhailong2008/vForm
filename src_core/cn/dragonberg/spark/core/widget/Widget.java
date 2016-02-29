package cn.dragonberg.spark.core.widget;

import java.util.Map;

import cn.dragonberg.spark.core.config.ConfigBo;

/**
 * 
 * @author liuhailong<liuhailong2008@foxmail.com>
 */
public interface Widget {
	
	/**
	 * 
	 * @param configId
	 * @return
	 */
	String getUI(String configId);
	
	/**
	 * 
	 * @param configId
	 * @param params
	 * @return
	 */
	String getData(String configId,Map<String,String> params);
	/**
	 * 
	 * @param configId
	 * @return
	 */
	ConfigBo getConfig(String configId);
}
