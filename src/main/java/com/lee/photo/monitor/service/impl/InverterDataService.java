package com.lee.photo.monitor.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.lee.photo.monitor.http.RealDataHttp;
import com.lee.photo.monitor.http.RealDataResp;
import com.lee.photo.monitor.http.RealDataResult;
import com.lee.photo.monitor.json.JsonResult;
import com.lee.photo.monitor.service.IInverterDataService;

@Service
public class InverterDataService implements IInverterDataService {

	@Override
	public JsonResult getMonthData() {
		return null;
	}

	@Override
	public JsonResult getDayData() {
		return null;
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
		return null;
	}

}
