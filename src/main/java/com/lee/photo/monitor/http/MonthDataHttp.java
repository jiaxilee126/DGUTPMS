package com.lee.photo.monitor.http;

import java.util.Set;

public class MonthDataHttp extends QueryBaseHttp {
	private Set<String> date;
	
	private Set<Double> value;
	
	public Set<String> getDate() {
		return date;
	}
	
	public Set<Double> getValue() {
		return value;
	}
	
	@Override
	protected QueryBaseReq getReq() {
		MonthDataQeq req = new MonthDataQeq();
		req.setUrl();
		return req;
	}

	@Override
	public void responseArrived(QueryBaseResp resp) {
		MonthDataResp dataResp = (MonthDataResp)resp;
		Object[][] result = dataResp.getResult();
		for (int i = 0; i < result.length; i++) {
			this.date.add(result[i][0].toString());
			this.value.add(Double.valueOf(result[i][1].toString()));
			
		}
	
	}

}
