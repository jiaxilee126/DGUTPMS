package com.lee.photo.monitor.service;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonArray;

public class DataParseTest {
	public static void main(String[] args) {
		/*String dataArr = "[[113,3],[116,4],[118,9],[120,13]]";
		String sub = dataArr.substring(1, dataArr.length()-1);
		System.out.println(sub);
		
		String[] da = sub.split("]");
		for (String string : da) {
			System.out.println(string);
		}*/
		
		String source = "[[113,3],[116,4],[118,9],[120,13]]";
		
		ArrayList<ArrayList<Integer>> dataSource = new ArrayList<ArrayList<Integer>>();
		/*ArrayList<Integer> d1 = new ArrayList<Integer>();
		d1.add(100);
		d1.add(4);
		dataSource.add(d1);
		
		ArrayList<Integer> d2 = new ArrayList<Integer>();
		d2.add(130);
		d2.add(8);
		dataSource.add(d2);*/
		//String bb = "[1,2,3,4]";
		ArrayList<Integer> ss = new ArrayList<Integer>();
		StringWriter stringWriter = new StringWriter();
		int[] arr = new int[]{1,2,3,4};
		//System.out.println(arr.toString());
		//System.out.println(Arrays.toString(arr));
		JSONArray jsonArray = new JSONArray(source);
		
		
		//System.out.println(jsonObject.toJSONArray());
		ObjectMapper om = new ObjectMapper();
		try {
			//stringWriter.write(bb);
			//om.writeValue(stringWriter, dataSource);
			//om.readValue(source, dataSource.getClass());
			//JsonArray jsonArray = new JsonArray();
			//jsonArray.write(stringWriter);
			//System.out.println(stringWriter.toString());
			System.out.println(jsonArray.toString());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONArray ja = (JSONArray)jsonArray.get(i);
				System.out.println(ja.get(1));
			}
			
			System.out.println(jsonArray.get(3));
			//om.readValue(bb, ss.getClass());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(dataSource.size());
		//System.out.println(ss.size());
		
		
		//System.out.println(stringWriter.toString());
	}
}
class DataSource{
	private ArrayList<ArrayList<Integer>> dataSource ;

	public ArrayList<ArrayList<Integer>> getDataSource() {
		return dataSource;
	}

	public void setDataSource(ArrayList<ArrayList<Integer>> dataSource) {
		this.dataSource = dataSource;
	}
	
}
