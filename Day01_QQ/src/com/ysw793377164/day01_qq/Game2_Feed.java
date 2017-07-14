package com.ysw793377164.day01_qq;

public class Game2_Feed {
	private int id, oid;
	private String category;
	private Game2_Data data;
	public synchronized int getId() {
		return id;
	}
	public synchronized void setId(int id) {
		this.id = id;
	}
	public synchronized int getOid() {
		return oid;
	}
	public synchronized void setOid(int oid) {
		this.oid = oid;
	}
	public synchronized String getCategory() {
		return category;
	}
	public synchronized void setCategory(String category) {
		this.category = category;
	}
	public synchronized Game2_Data getData() {
		return data;
	}
	public synchronized void setData(Game2_Data data) {
		this.data = data;
	}
	
}
