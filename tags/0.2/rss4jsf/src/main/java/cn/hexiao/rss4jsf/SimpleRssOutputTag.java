/**
 * @author Icess
 * @license Apache License Version 2.0
 */

package cn.hexiao.rss4jsf;

import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.webapp.UIComponentTag;

public class SimpleRssOutputTag extends UIComponentTag
{

    private String url;
    private String count;
    private String rssSiteStyleClass;
    private String rssSiteNameStyleClass;
    private String rssEntryTitleStyleClass;
    private String postTimeStyleClass;
    private String entrysSummaryStyleClass;
    private String readMoreStyleClass;
    private String rssEntryStyleClass;

    public SimpleRssOutputTag()
    {
    }

    public void release()
    {
        super.release();
    }

    protected void setProperties(UIComponent component)
    {
        super.setProperties(component);
        component.getAttributes().put("url", url);
        component.getAttributes().put("count", count);
        if(rssSiteStyleClass != null)
            component.getAttributes().put("rssSiteStyleClass", rssSiteStyleClass);
        if(rssSiteNameStyleClass != null)
            component.getAttributes().put("rssSiteNameStyleClass", rssSiteNameStyleClass);
        if(rssEntryTitleStyleClass != null)
            component.getAttributes().put("rssEntryTitleStyleClass", rssEntryTitleStyleClass);
        if(postTimeStyleClass != null)
            component.getAttributes().put("postTimeStyleClass", postTimeStyleClass);
        if(entrysSummaryStyleClass != null)
            component.getAttributes().put("entrysSummaryStyleClass", entrysSummaryStyleClass);
        if(readMoreStyleClass != null)
            component.getAttributes().put("readMoreStyleClass", readMoreStyleClass);
        if(rssEntryStyleClass != null)
            component.getAttributes().put("rssEntryStyleClass", rssEntryStyleClass);
    }

    public String getComponentType()
    {
        return "cn.hexiao.rss4jsf.SimpleRssOutput";
    }

    public String getRendererType()
    {
        return null;
    }

    public String getCount()
    {
        return count;
    }

    public void setCount(String count)
    {
        this.count = count;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getRssSiteStyleClass()
    {
        return rssSiteStyleClass;
    }

    public void setRssSiteStyleClass(String rssSiteStyleClass)
    {
        this.rssSiteStyleClass = rssSiteStyleClass;
    }

    public String getEntrysSummaryStyleClass()
    {
        return entrysSummaryStyleClass;
    }

    public void setEntrysSummaryStyleClass(String entrysSummaryStyleClass)
    {
        this.entrysSummaryStyleClass = entrysSummaryStyleClass;
    }

    public String getPostTimeStyleClass()
    {
        return postTimeStyleClass;
    }

    public void setPostTimeStyleClass(String postTimeStyleClass)
    {
        this.postTimeStyleClass = postTimeStyleClass;
    }

    public String getReadMoreStyleClass()
    {
        return readMoreStyleClass;
    }

    public void setReadMoreStyleClass(String readMoreStyleClass)
    {
        this.readMoreStyleClass = readMoreStyleClass;
    }

    public String getRssEntryTitleStyleClass()
    {
        return rssEntryTitleStyleClass;
    }

    public void setRssEntryTitleStyleClass(String rssEntryTitleStyleClass)
    {
        this.rssEntryTitleStyleClass = rssEntryTitleStyleClass;
    }

    public String getRssSiteNameStyleClass()
    {
        return rssSiteNameStyleClass;
    }

    public void setRssSiteNameStyleClass(String rssSiteNameStyleClass)
    {
        this.rssSiteNameStyleClass = rssSiteNameStyleClass;
    }

    public String getRssEntryStyleClass()
    {
        return rssEntryStyleClass;
    }

    public void setRssEntryStyleClass(String rssEntryStyleClass)
    {
        this.rssEntryStyleClass = rssEntryStyleClass;
    }
}
