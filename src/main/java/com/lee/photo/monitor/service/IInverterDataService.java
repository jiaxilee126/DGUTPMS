package com.lee.photo.monitor.service;

import com.lee.photo.monitor.json.JsonResult;

public interface IInverterDataService {
	/**
	 * @Description: 获取一年中每一月的数据
	 * @return JsonResult  
	 * @throws
	 * @author Jussi Lee
	 * @date 2018年11月19日
	 */
	JsonResult getMonthData();
	
	/**
	 * @Description: 获取一天中的功率曲线
	 * @return JsonResult  
	 * @throws
	 * @author Jussi Lee
	 * @date 2018年11月19日
	 */
	JsonResult getDayData();
	
	/**
	 * @Description: 获取实时数据
	 * @return JsonResult  
	 * @throws
	 * @author Jussi Lee
	 * @date 2018年11月19日
	 */
	JsonResult getRealData();
	
	JsonResult getYearData();
}
