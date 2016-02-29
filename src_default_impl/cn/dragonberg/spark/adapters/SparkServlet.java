package cn.dragonberg.spark.adapters;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dragonberg.spark.config.ConfigProviderImpl;
import cn.dragonberg.spark.core.adapter.SparkAdapter;
import cn.dragonberg.spark.core.adapter.SparkAdapterSupport;
import cn.dragonberg.spark.core.config.ConfigManager;
import cn.dragonberg.spark.core.config.ConfigProvider;

/**
 * Servlet implementation class SparkServlet.
 * 
 * @author liuhailong<liuhailong2008#foxmail.com>
 */
@WebServlet("/spark")
public class SparkServlet extends HttpServlet implements SparkAdapter {
	
	private static final long serialVersionUID = 1L;
	
	public static final String CONFIG_ID_KEY = "cid";
	
	public static final String METHOD_KEY = "m";
	
	
	
	@Override
	public String getParameter(Object in, String name) {
		HttpServletRequest request = (HttpServletRequest)in;
		String ret = request.getParameter(name);
		return ret;
	}
	
	@Override
	public String getConfigId(Object in) {
		String ret = this.getParameter(in, CONFIG_ID_KEY);
		return ret;
	}

	@Override
	public String getMethod(Object in) {
		String ret = this.getParameter(in, METHOD_KEY);
		return ret;
	}

	@Override
	public String beforeOutput(String ret) {
		// TODO Auto-generated method stub
		return ret;
	}
	
	@Override
	public Map<String, String> getParameters(Object in) {
		HttpServletRequest request = (HttpServletRequest)in;
		// TODO
		return null;
	}


	
    /**
     * Default constructor. 
     */
    public SparkServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ConfigProvider provider = new ConfigProviderImpl();
		ConfigManager.registerProvider(provider);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ret = SparkAdapterSupport.service(this, request);
		response.getWriter().write(ret);
	}

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.service(request,response);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}



	

}
