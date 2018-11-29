package com.lee.photo.monitor.http;

public class RealDataHttp extends QueryBaseHttp {
	private RealDataResult result;
	
	public RealDataResult getResult(){
		return result;
	}
	@Override
	protected QueryBaseReq getReq() {
		RealDataReq req = new RealDataReq();
		req.setUrl();
		return req;
	}

	@Override
	public void responseArrived(QueryBaseResp resp) {
		RealDataResp r = (RealDataResp)resp;
		result.setTodayEnergy(r.getTodayEnergy()/1000.0);
		result.setTotalEnergy(r.getTotalEnergy()/1000.0);
		result.setCo2(r.getTotalEnergy()*1.08/1000.0);
		
	}
	
	public static void main(String[] args) {
		RealDataHttp http = new RealDataHttp();
		http.query(RealDataResp.class);
		
		
		http.getResult();
	}
}
