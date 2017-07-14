package com.ysw793377164.day01_qq;

public class Game2_First {

	private String status;
	private Game2_Paramz paramz;
	public synchronized String getStatus() {
		return status;
	}
	public synchronized void setStatus(String status) {
		this.status = status;
	}
	public synchronized Game2_Paramz getParamz() {
		return paramz;
	}
	public synchronized void setParamz(Game2_Paramz paramz) {
		this.paramz = paramz;
	}
	
}
