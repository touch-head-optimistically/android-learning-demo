package com.ysw793377164.day01_qq;

import java.util.List;

public class Game2_Paramz {

	private List<Game2_Feed> feeds;
	private int PageIndex, PageSize, TotalCount, TotalPage;
	public synchronized List<Game2_Feed> getFeeds() {
		return feeds;
	}
	public synchronized void setFeeds(List<Game2_Feed> feeds) {
		this.feeds = feeds;
	}
	public synchronized int getPageIndex() {
		return PageIndex;
	}
	public synchronized void setPageIndex(int pageIndex) {
		PageIndex = pageIndex;
	}
	public synchronized int getPageSize() {
		return PageSize;
	}
	public synchronized void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public synchronized int getTotalCount() {
		return TotalCount;
	}
	public synchronized void setTotalCount(int totalCount) {
		TotalCount = totalCount;
	}
	public synchronized int getTotalPage() {
		return TotalPage;
	}
	public synchronized void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}
	
}
