package com.goldpalm.rd.data.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.goldpalm.rd.data.app.model.ChartModel;
import com.goldpalm.rd.data.app.model.ChartModel.Pie;
import com.goldpalm.rd.data.app.model.ChartModel.Series;
import com.goldpalm.rd.data.app.model.ChartModel.YAxis;
import com.goldpalm.rd.data.web.highchart.ChartConstant;
import com.goldpalm.rd.data.web.highchart.PublicChartsInfo;
/**
 * 
 * @author zhaiyuyong@goldpalm.com.cn
 * 
 * 自定义报表组件 测试数据
 *
 */
@Controller
@RequestMapping("/main/test")
public class TestController {

	@RequestMapping("/init")
	public String init(Model model){
		return "/home/test";
	}
	/*@RequestMapping("/data")
	@ResponseBody
	public PublicChartsInfo getData(){
		String[] x = {"1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"};
		int[] y = {2,3,4,5,6,4,5,6,7,4,3,2};
		PublicChartsInfo publicChartsInfo = new PublicChartsInfo();
		publicChartsInfo.setxText("测试X轴标题");
		publicChartsInfo.setyText("测试Y轴标题");
		publicChartsInfo.setChartWidth(500);
		publicChartsInfo.setChartHight(500);
		publicChartsInfo.setSeriesName("2012");
		publicChartsInfo.setChartType(ChartConstant.CHART_LINE);
		publicChartsInfo.setxCategories(x);
		publicChartsInfo.setChartData(y);
		publicChartsInfo.setChartText("上海金棕榈");
		return publicChartsInfo;
	}*/
	@RequestMapping("/data")
	@ResponseBody
	public ChartModel getData(){
		ChartModel chartModel = new ChartModel();
		chartModel.setxText("");
		chartModel.setTitle("主标题");
		chartModel.setSubTitle("副标题");
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
		series1.setType("line");
		series1.setyAxis(0);
		int[] data1 = {2,3,4,5,6,3,3,2,4,5,4,2};
		series1.setData(data1);
		Series series2 = new Series();
		series2.setName("2013");
		series2.setType("line");
		series2.setyAxis(0);
		int[] data2 = {5,6,3,4,5,6,7};
		series2.setData(data2);
		
		Series series3 = new Series();
		series3.setName("2014");
		series3.setType("pie");
		series3.setyAxis(0);
		int[] data3 = {1,2,1,2,1,2,1,3,1,2,4,1};
		series3.setData(data3);
		List<Series> series = new ArrayList<Series>();
		series.add(series1);
		series.add(series2);
		//series.add(series3);

		chartModel.setSeries(series);
		
		List<YAxis> yAxis = new ArrayList<YAxis>();
		YAxis yAxi1 = new YAxis();
		yAxi1.setTitle("测试Y1标题");
		yAxi1.setOpposite(false);
		yAxi1.setReversed(false);
		yAxis.add(yAxi1);
		
		YAxis yAxi2 = new YAxis();
		yAxi2.setTitle("测试Y2标题");
		yAxi2.setOpposite(true);
		yAxi2.setReversed(false);
		//yAxis.add(yAxi2);
		
		Pie pie = new Pie();
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("key", "男");
		map1.put("value", 45);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("key", "女");
		map2.put("value", 55);
		list.add(map1);
		list.add(map2);
		pie.setData(list);
		chartModel.setPie(pie);
		chartModel.setyAxis(yAxis);
		return chartModel;
	}
}
