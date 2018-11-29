package com.lee.photo.monitor.http;

public class MonthDataResp extends QueryBaseResp {
	//[["2017.12",83.31],["2018.01",60.58]]
	
	private Object[][] result = new Object[12][2];

	public Object[][] getResult() {
		return result;
	}

	public void setResult(Object[][] result) {
		this.result = result;
	}
	
}
