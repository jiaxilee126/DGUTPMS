package com.lee.photo.monitor.http;

import java.util.Set;
import java.util.TreeSet;

import org.json.JSONArray;

public class YearDataHttp extends QueryBaseHttp {
	
	public Set<String> date = new TreeSet<String>();
	
	public Set<Double> value = new TreeSet<Double>();
	
	
	public Set<String> getDate() {
		return date;
	}
	
	public Set<Double> getValue() {
		return value;
	}
	
	@Override
	protected QueryBaseReq getReq() {
		YearDataReq req = new YearDataReq();
		req.setUrl();
		return req;
	}

	@Override
	public void responseArrived(QueryBaseResp resp) {
	}
	
	public void responseArrive(String resp) {
		JSONArray jsonArray = new JSONArray(resp);
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONArray ja = (JSONArray)jsonArray.get(i);
			date.add(ja.getString(0));
			value.add(ja.getDouble(1));
			System.out.println(ja.get(1));
		}
	}
	
	public static void main(String[] args) {
		YearDataHttp http = new YearDataHttp();
		String resp = "[[\"2017.12\",83.31],[\"2018.01\",60.58],[\"2018.02\",66.39],[\"2018.03\",91.72],[\"2018.04\",72.55],[\"2018.05\",105.36],[\"2018.06\",76.08],[\"2018.07\",92.34],[\"2018.08\",76.16],[\"2018.09\",87.75],[\"2018.10\",85.87],[\"2018.11\",39.02]]";
		
		http.responseArrive(resp);
		
		Set<String> dates = http.getDate();
		for (String string : dates) {
			System.out.println(string);
		}
		
		Set<Double> values = http.getValue();
		for (Double double1 : values) {
			System.out.println(double1);
		}
	}
	
}
