package com.lee.photo.monitor.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public abstract class QueryBaseHttp {
private static final Logger logger = Logger.getLogger(QueryBaseHttp.class);
	
	
	protected abstract QueryBaseReq getReq();
	
	public abstract void responseArrived(QueryBaseResp resp);
	
	public QueryBaseResp query(Class<? extends QueryBaseResp> cls){
		QueryBaseReq req = this.getReq();
		
		String resp = null;
		QueryBaseResp baseResp = null;
		ObjectMapper om = new ObjectMapper();
		om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
                false);
		//进行时间序列化配置
		try {
			OkHttpClient client = new OkHttpClient();
			okhttp3.OkHttpClient.Builder builder = client.newBuilder();
			builder.connectTimeout(20, TimeUnit.SECONDS).build();
			builder.readTimeout(20, TimeUnit.SECONDS).build();
			client = builder.build();
			//System.out.println(stringWriter.toString());
			
			Request request = new Request.Builder().
					url(req.getUrl()).
					build();
			Response response = client.newCall(request).execute();
			resp = response.body().string();
			baseResp = om.readValue(resp, cls);
		} catch (IOException e) {
			logger.error(e.getMessage());
			return null;
		}
		return baseResp;
	}
	
	
	
	
}
