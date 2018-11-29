package com.lee.photo.monitor.http;

public class DayDataReq extends QueryBaseReq {

	@Override
	protected String setUrl() {
		//http://10.208.127.16/nep/static/local/0_detail/?1542554895/
		return "/static/local/0_detail/?"+System.currentTimeMillis();
	}
}
