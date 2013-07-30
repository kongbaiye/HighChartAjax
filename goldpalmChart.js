/**
 * 自定义报表
 * 
 * 根据JavaBean 自动生成 需要的报表
 * 1、1条X轴
 * 2、多条Y轴，并且设置Y轴的相对位置
 * 3、多条数据 并且每条数据支持不同的图形  （1）直线（2）曲线（3）柱状图（4）饼形图
 */

function goldpalmChart(containerId, obj){
	this.containerId = containerId;//报表对应的DIV id
	var chartText = obj['title'];//报表标题
	var chartSubTitle = obj['subTitle'];//报表副标题
	var xAxis = obj['xAxis'];//X轴数据
	var xText = obj['xText'];//X轴标题
	var series = obj['series'];//数据点  ？？？？待优化2013/07/30
	var yAxis = obj['yAxis'];//Y轴数据
	var options = {
			chart: {
				renderTo : 'container',
	            type: 'line',
	            marginRight: 50,
	            marginBottom: 60
	        },
	        title: {
	            text: '',
	            x: -20 //center
	        },
	        xAxis: {
	            categories: [],
	            title : {
					text : ''
				}
	        },
	        yAxis: [],
	        series: [],
	        credits:{
	        	text : '上海金棕榈企业机构     '+ new Date().toLocaleString(),
	        	href:'http://www.goldpalm.com.cn'
	        },
	        loading:{
	        	labelStyle: {
	                fontWeight: 'bold',
	                position: 'relative',
	                top: '1em'
	            },
	            style:{
	            	 position: 'absolute',
	                 backgroundColor: 'white',
	                 opacity: 0.5,
	                 textAlign: 'center'
	            }
	        },
	        subtitle: {
	        	text:''
	        },
	        plotOptions: {
	          column: {
	            pointPadding: 0.3,
	            borderWidth: 1,
	            dataLabels:{
	            	enabled:true,
	            	formatter:function(){
	            		var color = this.series.color;
		            	var content = '<span style="color:'+color+';padding:0">'+this.y+'</span>';
		            	return content;
	            	},
		            align:'left'
	            }
	          },
	          line:{
	        	  dataLabels:{
		              enabled:true,
		              formatter:function(){
		            	 var color = this.series.color;
		            	 var content = '<span style="color:'+color+';padding:0">'+this.y+'</span>';
		            	 return content;
		              },
		              align:'right'
		          } 
	          },
	          pie:{
	        	  center: [100, 10],
	        	  allowPointSelect: true,
	                cursor: 'pointer',
	                dataLabels: {
	                    enabled: true,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                }
	          }
	       }
	};
	options.chart.renderTo = containerId;//报表DIV
	options.title.text = chartText;
	options.subtitle.text = chartSubTitle;
	var x = [];
	//alert(xAxis);
	for(var i=0;i<xAxis.length;i++){
		x.push(xAxis[i]);
	}
	options.xAxis.categories = x;
	options.xAxis.title.text = xText;
	
	for(var i=0;i<series.length;i++){
		var record = series[i];
		options.series[i] = new Object();
		options.series[i].name = record['name'];
		options.series[i].type = record['type'];
		options.series[i].yAxis = record['yAxis'];
		
		if(record['type']=='pie'){
			var datas = [];
			for(var j=0;j<record['data'].length;j++){
				var d = [];
				d.push(x[j]);
				d.push(record['data'][j]);
				datas.push(d);
			}
			//alert(datas);
			options.series[i].data = datas;
		}else {
			options.series[i].data = record['data'];
		}
	}
	for(var i=0;i<yAxis.length;i++){
		var record = yAxis[i];
		options.yAxis[i] = new Object();
		options.yAxis[i].title = new Object();
		options.yAxis[i].title.text =record['title']; 
		options.yAxis[i].opposite = record['opposite'];
		options.yAxis[i].reversed = record['reversed'];
	}
	//alert(JSON.stringify(options));
	//$("#container").html(JSON.stringify(options));
	var chart = new Highcharts.Chart(options);
}