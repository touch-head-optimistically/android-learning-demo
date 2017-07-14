package com.example.day07_project;
import java.util.List;


public class Paramz {

	private List<Feed> feeds;
	private int PageIndex;
	private int PageSize;
	private int TotalCount;
   private int  TotalPage;
public List<Feed> getFeeds() {
	return feeds;
}
public void setFeeds(List<Feed> feeds) {
	this.feeds = feeds;
}
public int getPageIndex() {
	return PageIndex;
}
public void setPageIndex(int pageIndex) {
	PageIndex = pageIndex;
}
public int getPageSize() {
	return PageSize;
}
public void setPageSize(int pageSize) {
	PageSize = pageSize;
}
public int getTotalCount() {
	return TotalCount;
}
public void setTotalCount(int totalCount) {
	TotalCount = totalCount;
}
public int getTotalPage() {
	return TotalPage;
}
public void setTotalPage(int totalPage) {
	TotalPage = totalPage;
}
   
}
