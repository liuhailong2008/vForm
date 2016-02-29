package cn.dragonberg.spark.core.adapter;

import java.util.Map;

import cn.dragonberg.spark.core.factory.SparkFactory;
import cn.dragonberg.spark.core.widget.Widget;


/**
 * 
 * @author liuhailong<liuhailong2008#foxmail.com>
 */
public class SparkAdapterSupport {

	public static String service(SparkAdapter adapter,Object in){
		
		String configId = adapter.getConfigId(in);

		Widget widget = SparkFactory.getWidget(configId);
		
		String method = adapter.getMethod(in);
		
		
		// TODO cache here
		String ret = "";
		if("ui".equalsIgnoreCase(method)){
			ret = widget.getUI(configId);
		}else{
			Map<String,String> params = null;
			ret = widget.getData(configId, params);
		}
		
		ret = adapter.beforeOutput(ret);
		
		return ret;
	}

}
