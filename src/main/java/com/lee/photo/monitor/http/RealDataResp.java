package com.lee.photo.monitor.http;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RealDataResp extends QueryBaseResp {
	@JsonProperty("td")
	private long todayEnergy;
	
	@JsonProperty("tt")
	private long totalEnergy;

	public long getTodayEnergy() {
		return todayEnergy;
	}

	public void setTodayEnergy(long todayEnergy) {
		this.todayEnergy = todayEnergy;
	}

	public long getTotalEnergy() {
		return totalEnergy;
	}

	public void setTotalEnergy(long totalEnergy) {
		this.totalEnergy = totalEnergy;
	}
}
