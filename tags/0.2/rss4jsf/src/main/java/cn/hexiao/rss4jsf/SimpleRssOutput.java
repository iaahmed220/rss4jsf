/**
 * @author Icess, Harlan Iverson
 * @license Apache License Version 2.0
 */

package cn.hexiao.rss4jsf;

import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gnu.stealthp.rsslib.*;

import cn.hexiao.rss4jsf.view.RssItem;
import cn.hexiao.rss4jsf.view.RssChannel;

public class SimpleRssOutput {

	String url;

	RSSHandler handler;

	private static final Log log = LogFactory.getLog(SimpleRssOutput.class);

	private static final String DEFAULT_ITEM_CLASS = RssItem.class.getName();
	private static final String DEFAULT_CHANNEL_CLASS = RssChannel.class.getName();

	public SimpleRssOutput(String url) {
		this.url = url;
		try {
			handler = new RSSHandler();
			URL urlWrap = new URL(this.url);
			RSSParser.parseXmlFile(urlWrap, handler, false);
		} catch (Exception e) {
			System.out
					.println("Can not get the rss content, Please check the rss adress is available.");
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public RssChannel getChannel() {
		// this could be customizable
		//String streamClass = DEFAILT_STREAM_CLASS;
		
		RSSChannel channel = handler.getRSSChannel();
		RssChannel viewChannel = new RssChannel( getUrl(),channel.getTitle(),  channel.getLink(), channel.getItems().size() );
		
		return viewChannel;
	}

	public List<RssItem> getMultipleItems(int numberOfItems) throws InvalidItemClassException {
		LinkedList readerItems = handler.getRSSChannel().getItems();
		int num = readerItems.size() <= numberOfItems ? readerItems.size() : numberOfItems;
		
		List<RssItem> returnItems = new ArrayList<RssItem>();

		// this could be customizable in the future
		String itemClass = DEFAULT_ITEM_CLASS;

		for (int i = 0; i < num; i++) {
			RSSItem readerItem = (RSSItem)readerItems.get(i);

			try {

				RssItem viewRssItem = (RssItem) Class.forName(itemClass).newInstance();
				viewRssItem.setUrl(readerItem.getLink());
				viewRssItem.setDate(readerItem.getPubDate());
				viewRssItem.setAuthor(readerItem.getAuthor());
				viewRssItem.setTitle(readerItem.getTitle());
				viewRssItem.setBody(readerItem.getDescription());
				
				returnItems.add( viewRssItem );
			} catch (InstantiationException e) {
				String error = "The class [" + itemClass + "] is not instantiatable (abstract?)";
				log.error(error);
				throw new InvalidItemClassException( error );
			} catch (ClassNotFoundException e) {
				String error = "The class [" + itemClass + "] could not be found";
				log.error(error);
				throw new InvalidItemClassException( error );
			} catch (IllegalAccessException e) {
				String error = "The class [" + itemClass + "] is not visisble in the current scpe (not public?)";
				log.error(error);
				throw new InvalidItemClassException( error );
			}
		}

		return returnItems;
	}


	public String getRssName() {
		return handler.getRSSChannel().getTitle();
	}

	public String getRssSiteUrl() {
		return handler.getRSSChannel().getLink();
	}
}
