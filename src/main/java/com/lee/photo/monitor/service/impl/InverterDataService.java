package com.lee.photo.monitor.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.lee.photo.monitor.http.DayDataHttp;
import com.lee.photo.monitor.http.MonthDataHttp;
import com.lee.photo.monitor.http.MonthDataResp;
import com.lee.photo.monitor.http.RealDataHttp;
import com.lee.photo.monitor.http.RealDataResp;
import com.lee.photo.monitor.http.RealDataResult;
import com.lee.photo.monitor.http.YearDataHttp;
import com.lee.photo.monitor.json.JsonResult;
import com.lee.photo.monitor.service.IInverterDataService;

@Service
public class InverterDataService implements IInverterDataService {

	@Override
	public JsonResult getMonthData() {
		MonthDataHttp http = new MonthDataHttp();
		http.query(MonthDataResp.class);
		
		String resp = "";
		
		http.responseArrived(resp);
		
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("date", http.getDate());
		map.put("value", http.getValue());
		return JsonResult.data(map);
	}

	@Override
	public JsonResult getDayData() {
		DayDataHttp http = new DayDataHttp();
		http.query(MonthDataResp.class);
		
		String resp = "";
		
		//http.responseArrived(resp);
		
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("date", http.getDate());
		map.put("value", http.getValue());
		return JsonResult.data(map);
	}

	@Override
	public JsonResult getRealData() {
		RealDataHttp http = new RealDataHttp();
		http.query(RealDataResp.class);
		RealDataResult result = http.getResult();
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("todayEnergy", result.getTodayEnergy());
		data.put("totalEnergy", result.getTotalEnergy());
		data.put("co2", result.getCo2());
		
		return JsonResult.data(data);
	}

	@Override
	public JsonResult getYearData() {
		YearDataHttp http = new YearDataHttp();
		http.query(MonthDataResp.class);
		
		String resp = "";
		
		http.responseArrive(resp);
		
		Map<String, Object> map = new TreeMap<String, Object>();
		map.put("date", http.getDate());
		map.put("value", http.getValue());
		return JsonResult.data(map);
	}

}
