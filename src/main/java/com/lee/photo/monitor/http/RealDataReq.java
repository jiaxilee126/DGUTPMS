package com.lee.photo.monitor.http;

public class RealDataReq extends QueryBaseReq {

	@Override
	protected String setUrl() {
		return "realdata/tt/0/"+System.currentTimeMillis();
	}

}
