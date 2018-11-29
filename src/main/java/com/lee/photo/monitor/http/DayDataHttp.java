package com.lee.photo.monitor.http;

import java.util.Set;

public class DayDataHttp extends QueryBaseHttp {
	
	private Set<Long> date;
	
	private Set<Double> value;
	
	
	public Set<Long> getDate() {
		return date;
	}

	public Set<Double> getValue() {
		return value;
	}

	@Override
	protected QueryBaseReq getReq() {
		return null;
	}

	@Override
	public void responseArrived(QueryBaseResp resp) {
		DayDataResp dataResp = (DayDataResp)resp;
		
		Object[][] result = dataResp.getResult();
		for (int i = 0; i < result.length; i++) {
			this.date.add(Long.valueOf(result[i][0].toString()));
			this.value.add(Double.valueOf(result[i][1].toString()));
			
		}
	
	}

}
