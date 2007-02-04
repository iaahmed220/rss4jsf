/**
 * @author Icess, Harlan Iverson
 * @license Apache License Version 2.0
 */

package cn.hexiao.rss4jsf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.el.ValueBinding;

import cn.hexiao.rss4jsf.view.RssChannel;
import cn.hexiao.rss4jsf.view.RssItem;


public class UISimpleRssOutput extends UIOutput
{

    private final String DIV_LABEL = "div";
    private final String CLASS_LABEL = "class";
    private final String SPAN_LABEL = "span";
    private final String A_LABEL = "a";
    private final String TITLE_LABEL = "title";
    private final String HREF_LABEL = "href";
    
    

    public UISimpleRssOutput()
    {
    }
    
    public void encodeOldMethod( FacesContext context ) {

        Map attrs = getAttributes();
        ResponseWriter writer = context.getResponseWriter();
        String url = (String)attrs.get("url");
        String count = (String)attrs.get("count");
        SimpleRssOutput rssOutput = new SimpleRssOutput(url);
        
        /*
        writeStyleClass(writer, attrs, "rssSiteStyleClass");
        writer.startElement("span", this);
        writeStyleClass(writer, attrs, "rssSiteNameStyleClass");
        writer.startElement("a", this);
        writer.writeAttribute("title", "Read full entry on this rss site", "title");
        writer.writeAttribute("href", rssOutput.getRssSiteUrl(), "href");
        writer.write(rssOutput.getRssName());
        writer.endElement("a");
        writer.endElement("span");
        writer.write("<br/><br/>");
        */
    	
    }

    public void encodeBegin(FacesContext context)
        throws IOException
    {

        
        UIComponent itemFacet = getFacet("item");
        
        if( itemFacet == null ) {
        	encodeOldMethod( context );
        	return;
        } else {
            Map attrs = getAttributes();
            ResponseWriter writer = context.getResponseWriter();
            
            String url = (String)attrs.get("url");
            String count = (String)attrs.get("count");
            String itemVar = attrs.containsKey("itemVar") ? (String)attrs.get("itemVar") : "item";
            String channelVar = attrs.containsKey("channelVar") ? (String)attrs.get("channelVar") : "channel";
            
            SimpleRssOutput rssOutput = new SimpleRssOutput(url);
	
            try {
            	// create a value binding so that the channel details are available to the
            	// header and item facets
            	RssChannel channel = rssOutput.getChannel();
            	context.getApplication().createValueBinding("#{" + channelVar + "}").setValue(context, channel);
            	
            	// encode the header facet if there is one
            	UIComponent headerFacet = getFacet("header");
            	if( headerFacet != null ) {
            		encodeRecursive(context, headerFacet);
            	}

            	
		        ArrayList<RssItem> rssItems = (ArrayList<RssItem>)rssOutput.getMultipleItems( Integer.valueOf(count).intValue() );
		        
		        for(RssItem item : rssItems)
		        {
		        	// create a value binding so that the item is available to the item facet
			        	context.getApplication().createValueBinding("#{" + itemVar + "}").setValue(context, item);
			        	
			        	// recursively encode the facet
			        	encodeRecursive( context, itemFacet );
	
		        }
		        
            	// encode the footer facet if there is one
            	UIComponent footerFacet = getFacet("header");
            	if( footerFacet != null ) {
            		encodeRecursive(context, footerFacet);
            	}
		        
        	} catch( InvalidItemClassException e ) {
        		// do we want to encode an error message?
        		// just propagate this for now
        		throw new IOException( "Could not encode RSS stream because of a problem with the RssItem class: "+e.getMessage() );
        	}
        }
    }
    
    private void encodeRecursive( FacesContext context, UIComponent c ) throws IOException {
    	c.encodeBegin( context );
    	if( c.getRendersChildren() ) {
    		c.encodeChildren(context);
    	} else {
    		for( UIComponent child : (List<UIComponent>)c.getChildren() ) {
    			encodeRecursive( context, child );
    		}
    	}
    	c.encodeEnd( context );
    }

    private void writeStyleClass(ResponseWriter writer, Map attrs, String key)
        throws IOException
    {
        String value = (String)attrs.get(key);
        if(value != null)
            writer.writeAttribute("class", value, value);
    }

    public void encodeEnd(FacesContext facescontext)
        throws IOException
    {
    }
}
