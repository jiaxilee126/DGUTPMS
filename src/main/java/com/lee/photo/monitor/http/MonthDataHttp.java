package com.lee.photo.monitor.http;

import java.util.LinkedList;
import java.util.Set;

import org.json.JSONArray;

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
	
	public void responseArrived(String resp) {
		//如果含有空值可以考虑使用linkedlist 去解析
		JSONArray jsonArray = new JSONArray(resp);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONArray ja = (JSONArray)jsonArray.get(i);
			date.add(ja.getString(0));
			value.add(ja.getDouble(1));
		}
	}
	
	
	
	public static void main(String[] args) {
		LinkedList<Integer> aa = new LinkedList<Integer>();
		aa.add(null);
		aa.add(1);
		aa.add(null);
		System.out.println(aa.size());
	}
}
