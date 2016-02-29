package cn.dragonberg.spark.core.config;

import java.util.HashMap;

/**
 * 
 * @author liuhailong<liuhailong2008#foxmail.com>
 */
public class ConfigBo extends HashMap<String,Object> {
	
	private String configId = "";
	private String widgetImplClz = "";
	
	public void setConfigId(String configId){
		this.configId = configId;
	}
	public String getConfigId(){
		return this.configId;
	}
	
	public String getWidgetImplClz() {
		return widgetImplClz;
	}
	public void setWidgetImplClz(String widgetImplClz) {
		this.widgetImplClz = widgetImplClz;
	}
	
	
	private static final long serialVersionUID = -3998925259948768957L;

}
