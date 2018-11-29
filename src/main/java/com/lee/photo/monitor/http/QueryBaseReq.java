package com.lee.photo.monitor.http;

public abstract class QueryBaseReq {
	
	private String baseUrl = "http://10.208.127.16/nep/static/local";
	
	protected abstract String setUrl();
	
	public String getUrl() {
		return this.baseUrl +this.setUrl();
	}
}
