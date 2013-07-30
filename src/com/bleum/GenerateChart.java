package com.bleum;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GenerateChart
 */
public class GenerateChart extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public GenerateChart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String realPath= request.getSession().getServletContext().getRealPath("/WEB-INF/classes")+"/option.properties";
		Properties props = new Properties();
		props.load(new FileInputStream(realPath));
		String jsonOptions = getJSONString(props);
		response.getOutputStream().write(jsonOptions.getBytes());
		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	public String getJSONString(Properties props) {
		
		StringBuilder builder = new StringBuilder();
		
		//datas
		String seriesData = "[{name: 'Hydra PSR',data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]},"
			+"{name: 'Hydra Knowledge Base',data: [3.9, 4.2, 5.7, 18.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]}]";
		builder.append("{'seriesData':"+seriesData);
		
   		String categoriesData = "['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']";
   		
   		builder.append(",'categoriesData':"+categoriesData);
		//options
		builder.append(",'options':{");
		Iterator<Entry<Object, Object>> i = props.entrySet().iterator();
		while(i.hasNext()){
			Entry<Object, Object> entry = i.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
			builder.append("'"+entry.getKey()+"':'"+entry.getValue()+"',");
		}
		String json = builder.substring(0, builder.length()-1)+"}}";
		System.out.println(json);
		return json;
		
	/*	return "{'cid':'" + cid + "', 'owner':'" + owner + "', 'username':'"
				+ username + "', 'aliasname':'" + aliasname + "', 'sendcount':'"
				+ sendcount + "', 'receivetime':'" + receivetime + "', 'vipscore':'"
				+ vipscore + "'}";*/
	}


}
