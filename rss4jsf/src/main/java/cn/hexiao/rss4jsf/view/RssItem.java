/**
 * Represents an Rss Item in the view
 * @author Harlan Iverson
 * @license Apache License Version 2.0
 */

package cn.hexiao.rss4jsf.view;

public class RssItem {
	String url;
	String date;
	String author;
	String title;
	String body;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getSummary() {
		String body = getBody();
		
        int le = body.length();
        return le <= 10 ? body : body.substring(0, le / 3) + " ...  ";
	}
	
	
	@Override
	public String toString() {
		return "RssItem: "+getTitle();
	}
}
