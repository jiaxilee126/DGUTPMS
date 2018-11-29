package com.lee.photo.monitor.http;

public class MonthDataQeq extends QueryBaseReq {

	@Override
	protected String setUrl() {
		return "static/local/0_month/?1542554895/"+System.currentTimeMillis();
	}

}
