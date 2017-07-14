package com.ysw793377164.day01_qq;

public class Game2_Data {

	private String subject, summary, cover, pic, format, changed;

	public synchronized String getSubject() {
		return subject;
	}

	public synchronized void setSubject(String subject) {
		this.subject = subject;
	}

	public synchronized String getSummary() {
		return summary;
	}

	public synchronized void setSummary(String summary) {
		this.summary = summary;
	}

	public synchronized String getCover() {
		return cover;
	}

	public synchronized void setCover(String cover) {
		this.cover = cover;
	}

	public synchronized String getPic() {
		return pic;
	}

	public synchronized void setPic(String pic) {
		this.pic = pic;
	}

	public synchronized String getFormat() {
		return format;
	}

	public synchronized void setFormat(String format) {
		this.format = format;
	}

	public synchronized String getChanged() {
		return changed;
	}

	public synchronized void setChanged(String changed) {
		this.changed = changed;
	}
	
}
