package com.lee.photo.monitor.http;

public class YearDataReq extends QueryBaseReq {

	@Override
	protected String setUrl() {
		//url: 'http://10.208.127.16/nep/static/local/0_year/?1542554895/'+(new Date()).valueOf(),
		return "static/local/0_year/?1542554895/"+System.currentTimeMillis();
	}

}
