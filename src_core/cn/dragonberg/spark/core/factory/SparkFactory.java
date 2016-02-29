package cn.dragonberg.spark.core.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.dragonberg.spark.core.config.ConfigBo;
import cn.dragonberg.spark.core.config.ConfigManager;
import cn.dragonberg.spark.core.widget.Widget;

/**
 * 
 * @author liuhailong<liuhailong2008#foxmail.com>
 */
public class SparkFactory {
	
	protected static Map<String,Widget> widgets = new ConcurrentHashMap<String,Widget>();
	
	public static Widget getWidget(String configId){
		Widget ret = widgets.get(configId);
		if(ret==null){
			ret = buildWidget(configId);	
		}
		return ret;
	}

	private static Widget buildWidget(String configId) {
		ConfigBo configBo = ConfigManager.get(configId);
		String widgetImplClz = configBo.getWidgetImplClz();
		try {
			Class<?> clz = Class.forName(widgetImplClz);
			Widget ret = (Widget)clz.newInstance();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Faild when create widget instance , " + e.getMessage());
		} 
	}
}
