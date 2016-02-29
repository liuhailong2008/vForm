package cn.dragonberg.spark.core.config;

/**
 * 
 * @author liuhailong<liuhailong2008#foxmail.com>
 */
public interface ConfigProvider {
	/**
	 * Global widget register and configuration management.
	 * 
	 * @param configId
	 * @return ConfigBo with widgetImplClz property
	 */
	public ConfigBo get(String configId);
}
