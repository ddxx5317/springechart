package com.service;

import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.PointerType;
import com.github.abel533.echarts.code.SelectedMode;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Map;
import com.github.abel533.echarts.series.MapLocation;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.LineStyle;

/**
 * @author lyx
 *	
 * 2015-6-12下午1,34,50
 *
 *springechart.com.service.EchartsT
 */
public class EchartsT {

	
	public Option echartTest() 
	{
		//GsonOption option = new GsonOption();
	
		
		//划线------------------
		
			/*Option option = new Option();
		option.legend("高度(km)与气温(°C)变化关系");

	    option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar), Tool.restore, Tool.saveAsImage);

	    option.calculable(true);
	    option.tooltip().trigger(Trigger.axis).formatter("Temperature , <br/>{b}km , {c}°C");

	    ValueAxis valueAxis = new ValueAxis();
	    valueAxis.axisLabel().formatter("{value} °C");
	    option.xAxis(valueAxis);

	    CategoryAxis categoryAxis = new CategoryAxis();
	    categoryAxis.axisLine().onZero(false);
	    categoryAxis.axisLabel().formatter("{value} km");
	    categoryAxis.boundaryGap(false);
	    categoryAxis.data(0, 10, 20, 30, 40, 50, 60, 70, 80);
	    option.yAxis(categoryAxis);

	    Line line = new Line();
	    line.smooth(true).name("高度(km)与气温(°C)变化关系").data(15, -50, -56.5, -46.5, -22.1, -2.5, -27.7, -55.7, -76.5).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
	    option.series(line);*/
	    	
		
		 ItemStyle dataStyle = new ItemStyle();
	        dataStyle.normal().label(new Label().show(false)).labelLine().show(false);

	        ItemStyle placeHolderStyle = new ItemStyle();
	        placeHolderStyle.normal().color("rgba(0,0,0,0)").label(new Label().show(false)).labelLine().show(false);
	        placeHolderStyle.emphasis().color("rgba(0,0,0,0)");

	        Option option = new Option();
	        option.title().text("你幸福吗？")
	                .subtext("From ExcelHome")
	                .sublink("http://e.weibo.com/1341556070/AhQXtjbqh")
	                .x(X.center)
	                .y(Y.center)
	                .itemGap(20)
	                .textStyle().color("rgba(30,144,255,0.8)")
	                .fontFamily("微软雅黑")
	                .fontSize(35)
	                .fontWeight("bolder");
	        option.tooltip().show(true).formatter("{a} <br/>{b} : {c} ({d}%)");
	        option.legend().orient(Orient.vertical)
	                .x("(function(){return document.getElementById('main').offsetWidth / 2;})()")
	                .y(56)
	                .itemGap(12)
	                .data("68%的人表示过的不错", "29%的人表示生活压力很大", "3%的人表示“我姓曾”");
	        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage,Tool.dataZoom);

	        Pie p1 = new Pie("1");
	        p1.clockWise(false).radius(125, 150).itemStyle(dataStyle)
	                .data(new Data("68%的人表示过的不错", 68), new Data("invisible", 32).itemStyle(placeHolderStyle));

	        Pie p2 = new Pie("2");
	        p2.clockWise(false).radius(100, 125).itemStyle(dataStyle)
	                .data(new Data("29%的人表示生活压力很大", 29), new Data("invisible", 71).itemStyle(placeHolderStyle));

	        Pie p3 = new Pie("3");
	        p3.clockWise(false).radius(75, 100).itemStyle(dataStyle)
	                .data(new Data("3%的人表示“我姓曾”", 3), new Data("invisible", 97).itemStyle(placeHolderStyle));

	        option.series(p1, p2, p3);
		
		
		return option;  
	}
	
	
	
	//简单图形
	public Option simpleChart()
	{
		Option option = new Option();
		
		
		 /*  option.title().text("某地区蒸发量和降水量").subtext("纯属虚构");
	        option.tooltip().trigger(Trigger.axis);
	        option.legend("蒸发量", "降水量");
	        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
	        option.calculable(true);
	        option.xAxis(new CategoryAxis().data("1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月"));
	        option.yAxis(new ValueAxis());

	        Bar bar = new Bar("蒸发量");
	        bar.data(2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3);
	        bar.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
	        bar.markLine().data(new PointData().type(MarkType.average).name("平均值"));

	        Bar bar2 = new Bar("降水量");
	        bar2.data(2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3);
	        bar2.markPoint().data(new PointData("年最高", 182.2).xAxis(7).yAxis(183).symbolSize(18), new PointData("年最低", 2.3).xAxis(11).yAxis(3));
	        bar2.markLine().data(new PointData().type(MarkType.average).name("平均值"));

	        option.series(bar, bar2);*/
		
		
		
		
		option.title("未来一周气温变化", "纯属虚构");
		option.tooltip().trigger(Trigger.axis);
		option.legend().data("最低气温","最高气温").orient(Orient.horizontal);
		option.toolbox().show(true).feature(Tool.mark,Tool.dataView,
				Tool.magicType,//new MagicType(Magic.line,Magic.bar),
				Tool.restore,Tool.saveAsImage);
		
		option.calculable(true);
		//类目坐标-x轴
		CategoryAxis categoryAxis = new CategoryAxis();
			categoryAxis.boundaryGap(false);
			categoryAxis.data("周一","周二","周三","周四","周五","周六","周日");
			option.xAxis(categoryAxis);
		//值坐标-y轴
		ValueAxis valueAxis = new ValueAxis();
			valueAxis.axisLabel().formatter("{value} °C");
		option.yAxis(valueAxis);
	
		//series 画线
		Line line1 = new Line("最高气温");
		//尽量按照作者的格式来写,不然会一些错误,或是丢失一些效果
		line1.data(11, 11, 15, 13, 12, 13, 10);
		line1.markPoint().data(new PointData().type(MarkType.max).name("最大值"),new PointData().type(MarkType.min).name("最小值"));
		line1.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		
		Line line2 =new Line("最低气温");
		
		line2.data(1, -2, 2, 5, 3, 2, 0);
		line2.markPoint().data(new PointData("周最低",-2).xAxis(1).yAxis((int) -1.5));
		line2.markLine().data(new PointData().type(MarkType.average).name("平均值"));
		
		
		option.series(line1,line2);
		
	
		return option;
		
	}
	
	
	/**
	 * @return
	 * 扇形图
	 */
	
	public Option pieTest()
	{
		/* Option option = new Option();
		 //时间轴
        option.timeline().data("2013-01-01", "2013-02-01", "2013-03-01", "2013-04-01", "2013-05-01",
                new LineData("2013-06-01", "emptyStart6", 8), "2013-07-01", "2013-08-01", "2013-09-01", "2013-10-01",
                "2013-11-01", new LineData("2013-12-01", "star6", 8));
        option.timeline().autoPlay(true).label().formatter("function(s){return s.slice(0,7);}");
        //timeline变态的地方在于多个Option
        Option basic = new Option();
        basic.title().text("浏览器占比变化").subtext("纯属虚构");
        basic.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} , {c} ({d}%)");
        basic.legend().data("Chrome", "Firefox", "Safari", "IE9+", "IE8-");
        basic.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage, 
        		Tool.magicType
        	//	new MagicType(Magic.pie, Magic.funnel)
            //    .option(new MagicType.Option().funnel(
            //            new Funnel().x("25%").width("50%").funnelAlign(X.left).max(1548)))
             );
             
            //
        int idx = 1;
        basic.series(getPie(idx++).center("50%", "45%").radius("50%"));
        //加入
        option.options(basic);
        //构造11个数据
        Option[] os = new Option[11];
        for (int i = 0; i < os.length; i++) {
            os[i] = new Option().series(getPie(idx++));
        }
        option.options(os);
       
        return option;
        
    }

    
    public Pie getPie(int idx) {
       return new Pie().name("浏览器（数据纯属虚构）").data(
                new PieData("Chrome", idx * 128 + 80),
                new PieData("Firefox", idx * 64 + 160),
                new PieData("Safari", idx * 32 + 320),
                new PieData("IE9+", idx * 16 + 640),
                new PieData("IE8-", idx * 8 + 1280));
       */
    
		
		
		
		
		
		
		Option option = new Option();
		
		option.title("某站点用户访问来源", "纯属虚构");
		option.title().x(X.center);
		
		option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} , {c} ({d}%)");
	
		
		option.legend().orient(Orient.vertical).x(X.left).data("直接访问","邮件营销","联盟广告","视频广告","搜索引擎");
		
		option.toolbox().show(true).feature(Tool.mark,Tool.dataView,Tool.dataZoom,
				//new MagicType(Magic.pie,Magic.f)
				//Tool.magicType,
				Tool.restore,Tool.saveAsImage,
				new MagicType(Magic.pie, Magic.funnel)
                .option(new MagicType.Option().funnel(
                        new Funnel().x("25%").width("50%").funnelAlign(X.left).max(1000)))
				);
		
		option.calculable(true);
		
		
		Pie pie = new Pie("访问来源");
		pie.radius("55%").center("50%","60%");
		pie.data(new Data("直接访问",335),new Data("邮件营销",310),new Data("联盟广告",234),new Data("视频广告",135),new Data("搜索引擎",1548));
		
		
		
		option.series(pie);
		
		return option;
		
	}

    
    /**
     * @return
     * 地图
     */
    public Option mapTest()
    {
    	Option option = new Option();
    	
    	 Map map = new Map("Map");
         map.mapLocation(new MapLocation(X.left, Y.top, 500));
         map.selectedMode(SelectedMode.multiple);
         map.itemStyle().normal().borderWidth(2)
                 .borderColor("lightgreen").color("orange")
                 .label().show(true);

         map.itemStyle().emphasis()
                 .borderWidth(2).borderColor("#fff").color("#32cd32")
                 .label().show(true)
                 .textStyle().color("#fff");
         Data data = new Data("广东");
         data.value(Math.round(Math.random() * 1000));
         data.itemStyle().normal().color("#32cd32")
                 .label().show(true).textStyle().color("#fff").fontSize(15);
         data.itemStyle().emphasis().borderColor("yellow").color("#cd5c5c")
                 .label().show(false).textStyle().color("blue");

         map.data(data);
         map.markPoint().itemStyle().normal().color("skyblue");
         map.markPoint().data(new Data("天津", 350), new Data("上海", 103));

         map.geoCoord("上海", "121.4648", "31.2891").geoCoord("天津", "117.4219", "39.4189");

         option.series(map);
         return option;
    }
    
    
    //显示地图失败
    public Option  mapTest2() { 
    	Option option = new Option();
    	//标题
    	
    	Title title =new Title();
    	title.text("江西各地市人口密度");
    	title.link("http://www.baidu.com");
    	title.subtext("人口密度数据来自Wikipedia");
    	title.sublink("http://www.csdn.org");
    	option.setTitle(title);
    	//提示框
    	option.tooltip().trigger(Trigger.axis).formatter("{a}<br/>{b} (p / km2)");
    	
    	//工具栏
    	option.toolbox().show(true).orient(Orient.vertical).x(X.right).y(Y.center).feature(Tool.mark,Tool.dataView,Tool.restore,Tool.saveAsImage,Tool.dataZoom);
    	
    	//值域
    	option.dataRange().min(800).max(50000).text("High","Low").realtime(true).calculable(true).color("orangered","yellow","lightskyblue");
    	
    	//地图
    	//Map map = new Map("香港18区人口密度");
    	Map map = new Map("江西各地市人口密度");
    	
    	ItemStyle itemstyle = new ItemStyle();
    	itemstyle.emphasis().label().show(true);
    	itemstyle.normal().label().show(true);
    
    	map.mapType("江西").itemStyle(itemstyle);
    	//map.mapLocation().x("35%");
    	//map.mapType().
    	//map.roam(true);
    	
    	//map.markPoint().itemStyle().normal().borderColor("#87cefa");
    	//map.markPoint().itemStyle().emphasis().borderColor("'#1e90ff").borderWidth(5).label().show(true);
    	//map.markPoint().data(new Data("吉安市",20057.34));//.symbolSize(21);
    	
    	
    	map.data(new Data("吉安市",20057.34),new Data("南昌市",15477.48),new Data("九江市",31686.1),
    			new Data("宜春市",6992.6),new Data("抚州市",44045.49),new Data("萍乡市",40689.64),new Data("赣州市",21900.9),
    			new Data("上饶市",37659.78),new Data("鹰潭市",45180.97),new Data("新余市",55204.26),new Data("景德镇市",4918.26)/*,
    			new Data("屯门",5881.84),new Data("元朗",4178.01),new Data("北区",2227.92),new Data("大浦", 2180.98),
    			new Data("沙田",9172.94),new Data("西贡", 3368),new Data("离岛",806.98)*/);
    	
    	
    	/* nameMap, {
                "Central and Western","中西区",
                "Eastern","东区",
                "Islands","离岛",
                "Kowloon City","九龙城",
                "Kwai Tsing","葵青",
                "Kwun Tong","观塘",
                "North","北区",
                "Sai Kung","西贡",
                "Sha Tin","沙田",
                "Sham Shui Po","深水埗",
                "Southern","南区",
                "Tai Po","大埔",
                "Tsuen Wan","荃湾",
                "Tuen Mun","屯门",
                "Wan Chai","湾仔",
                "Wong Tai Sin","黄大仙",
                "Yau Tsim Mong","油尖旺",
                "Yuen Long","元朗"
    	 
    	
    		
    	
    			
    			new Data("Central and Western","中西区"),new Data("Eastern","东区"),new Data("Islands","离岛")
    	,new Data("Kowloon City","九龙城"),new Data("Kwai Tsing","葵青"),new Data("Kwun Tong","观塘")
    	,new Data("North","北区"),new Data("Sai Kung","西贡"),new Data("Sha Tin","沙田")
    	,new Data("Sham Shui Po","深水埗"),new Data("Southern","南区"),new Data("Tai Po","大埔")
    	,new Data("Tsuen Wan","荃湾"),new Data("Tuen Mun","屯门"),new Data("Wan Chai","湾仔")
    	,new Data("Wong Tai Sin","黄大仙"),new Data("Yau Tsim Mong","油尖旺"),new Data("Yuen Long","元朗")
    	//);
    	
    	//map.textFixed(new Data("Yau Tsim Mong","-10","0"));*/
    	/*map.geoCoord("Islands",
    			//"113.95", "22.26"
    			"121.4648", "31.2891");*/
    	
    	//系列
    	option.series(map);
		return option;
    }
    
    
    /**
     * @return
     * 堆积图
     */
    public Option stackChart()
    {
    	Option option = new Option();
    	
    	//标题
    	option.title("获取信息途径所占比重");
    	//提示框
    	option.tooltip().trigger(Trigger.axis);
    	option.tooltip().axisPointer().type(PointerType.shadow);
    	//图例说明
    	option.legend().data("直接访问","邮件营销","联盟广告","视频广告","搜索引擎","百度","谷歌","必应","其他");
    	//工具栏
    	option.toolbox().show(true).orient(Orient.vertical).x(X.right).y(Y.center)
    	.feature(Tool.mark,Tool.dataView,Tool.dataZoom,new MagicType(Magic.bar,Magic.line,Magic.stack,Magic.tiled),
    			Tool.restore,Tool.saveAsImage);
    	
    	//是否启用拖拽重计算特性
    	option.calculable(true);
    	
    	//x轴 -类目轴
    	option.xAxis(new CategoryAxis().data("周一","周二","周三","周四","周五","周六","周日"));
    	//Y轴 -值轴
    	option.yAxis(new ValueAxis());
    	
    	//系列 ,其中stack表示堆栈图的设置
    	Bar bar1 = new Bar("直接访问");
    	bar1.data(320, 332, 301, 334, 390, 330, 320);
    	
    	Bar bar2 = new Bar("邮件营销");
    	bar2.stack("广告");
    	bar2.data(120, 132, 101, 134, 90, 230, 210);
    	
    	Bar bar3 = new Bar("联盟广告");
    	bar3.stack("广告");
    	bar3.data(220, 182, 191, 234, 290, 330, 310);
    	
    	Bar bar4 = new Bar("视频广告");
    	bar4.stack("广告");
    	bar4.data(150, 232, 201, 154, 190, 330, 410);
    	
    	Bar bar5 = new Bar("搜索引擎");
    	bar5.data(862, 1018, 964, 1026, 1679, 1600, 1570);
    	//标记线
    	bar5.markLine().itemStyle().normal().lineStyle(new LineStyle().type(LineType.dashed));
        bar5.markLine().data(new PointData().type(MarkType.min),new PointData().type(MarkType.max));
    	
    	Bar bar6 = new Bar("百度");
    	bar6.stack("搜索引擎");
    	bar6.data(620, 732, 701, 734, 1090, 1130, 1120);
    	
    	Bar bar7 = new Bar("谷歌");
    	bar7.stack("搜索引擎");
    	bar7.data(120, 132, 101, 134, 290, 230, 220);
    	
     	Bar bar8 = new Bar("必应");
    	bar8.stack("搜索引擎");
    	bar8.data(60, 72, 71, 74, 190, 130, 110);
    	
    	Bar bar9 = new Bar("其他");
    	bar9.stack("搜索引擎");
    	bar9.data(62, 82, 91, 84, 109, 110, 120);
    	
    	//添加到系列中
    	option.series(bar1,bar2,bar3,bar4,bar5,bar6,bar7,bar8,bar9);

    	return option;
    }
}
