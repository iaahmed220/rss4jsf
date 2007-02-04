2007-01-30
Harlan Iverson <h dot iverson at gmail dot com>

To make rss4jsf work with Facelets you must add the included rss4jsf.taglib.xml to the META-INF directory of the jar.

To use the project with Maven, you must run the following commands to install jars manually:

mvn install:install-file \
-DgroupId=rsslib4j \
-DartifactId=rsslib4j \
-Dversion=0.2 \
-Dfile=path/to/rsslib4j-0.2.jar \
-DpomFile=pom-rsslib4j.xml  \
-Dpackaging=jar


mvn install:install-file \
-DgroupId=rss4jsf \
-DartifactId=rss4jsf \
-Dversion=0.1 \
-DpomFile=pom-rss4jsf.xml \
-Dfile=path/to/rss4jsf.jar \
-Dpackaging=jar


Getting rss4jsf hosted in codehaus's repository seems like a good way to go for the long run. Short term, Maven2 has Ant tasks that let you 
interact with the local maven repository--there could be an Ant task that runs these commands for you. 

[side note: I could not find your source code on SourceForge or Google Code; or I would add the stuff myself. Where can I get it?]