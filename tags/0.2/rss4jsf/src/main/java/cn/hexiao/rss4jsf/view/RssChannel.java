/**
 * Represents the RSS stream in the view.
 * @author Harlan Iverson
 * @license Apache License Version 2.0
 */

package cn.hexiao.rss4jsf.view;

public class RssChannel {
	String url;
	String name;
	String siteUrl;
	int numberOfItems;

	public RssChannel(String url, String name, String siteUrl, int numberOfItems) {
		super();
		this.url = url;
		this.name = name;
		this.siteUrl = siteUrl;
		this.numberOfItems = numberOfItems;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public String getSiteUrl() {
		return siteUrl;
	}
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
