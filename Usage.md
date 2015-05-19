## facelets ##
```
xmlns:rss4jsf="http://hexiao.cn/rss4jsf"
```

## jsp ##
```
<%@ taglib uri="http://www.hexiao.cn/rss4jsf" prefix="rss4jsf" %>
```

## usage ##
```
         <rss4jsf:simpleRssOutput
             url="my.rss"
             count="5"
             channelVar="channel"
             itemVar="item"
             >
             <f:facet name="header">
                 <div class="header">
                     <h2>#{channel.name}</h2>
                     <p>#{channel.numberOfItems} items. <a href="#{channel.siteUrl}">View Site</a>.</p>
                 </div>
             </f:facet>
             <f:facet name="item">
                 <div class="item">
                     <h3><a href="#{item.url}">#{item.title}</a></h3>
                     <p>#{item.author} - #{item.body }</p>
                 </div>
             </f:facet>
         </rss4jsf:simpleRssOutput>
```