package com.lee.photo.monitor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lee.photo.monitor.json.JsonResult;
import com.lee.photo.monitor.service.IInverterDataService;

@RequestMapping("/monitor")
@Controller
public class MonitorController {
	
	@Autowired
	private IInverterDataService inverterDataService;
	
	@RequestMapping("/overview")
	public String overview() {
		return "/monitor";
	}
	
	@RequestMapping("/realData")
	@ResponseBody
	public JsonResult getRealData(){
		return inverterDataService.getRealData();
	}
	
	@RequestMapping("/dayData")
	@ResponseBody
	public JsonResult getDayData(){
		return inverterDataService.getDayData();
	}
	
	@RequestMapping("/monthData")
	@ResponseBody
	public JsonResult getMonthData(){
		return inverterDataService.getMonthData();
	}
	
	@RequestMapping("/yearData")
	@ResponseBody
	public JsonResult getYearData(){
		return inverterDataService.getYearData();
	}
}
