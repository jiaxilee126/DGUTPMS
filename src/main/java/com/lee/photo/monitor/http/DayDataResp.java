package com.lee.photo.monitor.http;

public class DayDataResp extends QueryBaseResp {
	//[[1542546000000,0],[1542546060000,0],[1542546120000,0]]
	private Object[][] result = new Object[12][2];

	public Object[][] getResult() {
		return result;
	}

	public void setResult(Object[][] result) {
		this.result = result;
	}
}
