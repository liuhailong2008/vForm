package cn.dragonberg.spark.core.config;


/**
 * 
 * @author liuhailong<liuhailong2008#foxmail.com>
 */
public class ConfigManager {
	
	protected static ConfigProvider provider = null;
	
	public static ConfigBo get(String configId){
		if(provider!=null){
			ConfigBo ret = provider.get(configId);
			return ret;
		}
		throw new RuntimeException("No config provider registered.");
	}
	
	public static void registerProvider(ConfigProvider provider){
		ConfigManager.provider = provider ;
	}
}
