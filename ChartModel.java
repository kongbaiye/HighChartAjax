package com.goldpalm.rd.data.app.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChartModel implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private String title;//统计图标题
	private String subTitle;//统计副标题
	private String xText;//横坐标名称 
	private List<String> xAxis;//X轴
	private List<Series> series;
	private List<YAxis> yAxis; //Y轴
	private Pie pie;
	
	public String getxText() {
		return xText;
	}
	public void setxText(String xText) {
		this.xText = xText;
	}
	public List<YAxis> getyAxis() {
		return yAxis;
	}
	public void setyAxis(List<YAxis> yAxis) {
		this.yAxis = yAxis;
	}
	public List<String> getxAxis() {
		return xAxis;
	}
	public void setxAxis(List<String> xAxis) {
		this.xAxis = xAxis;
	}
	public List<Series> getSeries() {
		return series;
	}
	public void setSeries(List<Series> series) {
		this.series = series;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	public Pie getPie() {
		return pie;
	}
	public void setPie(Pie pie) {
		this.pie = pie;
	}
	public void test(){
		ChartModel chartModel = new ChartModel();
		List<String> xAxis = new ArrayList<>();
		xAxis.add("一月");
		xAxis.add("二月");
		xAxis.add("三月");
		xAxis.add("四月");
		xAxis.add("五月");
		xAxis.add("六月");
		xAxis.add("七月");
		xAxis.add("八月");
		xAxis.add("九月");
		xAxis.add("十月");
		xAxis.add("十一月");
		xAxis.add("十二月");
		chartModel.setxAxis(xAxis);
		Series series1 = new Series();
		series1.setName("2012");
	
		
		Series series2 = new Series();
		series2.setName("2013");
		List<Series> series = new ArrayList<Series>();
		series.add(series1);
		series.add(series2);
		chartModel.setSeries(series);
	}
	/**
	 * 数据 model
	 * @author zhaiyuyong@126.com
	 *
	 */
	public static class Series implements java.io.Serializable{
		private static final long serialVersionUID = 1L;
		private String name;
		private int[] data;
		private int yAxis;//对应的Y轴
		private String type;// 报表类型 直线、折线、饼
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	
		public int[] getData() {
			return data;
		}
		public void setData(int[] data) {
			this.data = data;
		}
		
		public int getyAxis() {
			return yAxis;
		}
		public void setyAxis(int yAxis) {
			this.yAxis = yAxis;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
	}
	/**
	 * Y轴 model
	 * @author zhaiyuyong@126.com
	 *
	 */
	public static class YAxis implements java.io.Serializable{
		private static final long serialVersionUID = 1L;
		private String title;//Y轴标题
		private boolean reversed;//Y轴是否逆转
		private boolean opposite;//是否 图示是否跟第一个在反方向位置
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public boolean isReversed() {
			return reversed;
		}
		public void setReversed(boolean reversed) {
			this.reversed = reversed;
		}
		public boolean isOpposite() {
			return opposite;
		}
		public void setOpposite(boolean opposite) {
			this.opposite = opposite;
		}
	}
	/**
	 * 
	 * @author zhaiyuyong@126.com
	 * 饼形图 model
	 *
	 */
	public static class Pie implements Serializable{
		private static final long serialVersionUID = 1L;
		private List<Map<String, Object>> data;
		public List<Map<String, Object>> getData() {
			return data;
		}
		public void setData(List<Map<String, Object>> data) {
			this.data = data;
		}
		
		
	}
}
