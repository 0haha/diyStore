FROM ubuntu
ENV BUILD_APP_NAME diyStore

RUN apt-get update
RUN apt-get install -y mysql-client

RUN  mkdir -p /home/admin/$BUILD_APP_NAME/java && \
     mkdir -p /home/admin/$BUILD_APP_NAME/tomcat

COPY apache-tomcat-7.0.88.tar.gz /home/admin/$BUILD_APP_NAME/tomcat
COPY jdk-8u161-linux-x64.tar.gz /home/admin/$BUILD_APP_NAME/java

RUN tar -zxvf  /home/admin/$BUILD_APP_NAME/java/jdk-8u161-linux-x64.tar.gz -C /home/admin/$BUILD_APP_NAME/java/
ENV JAVA_HOME /home/admin/$BUILD_APP_NAME/java/jdk1.8.0_161
ENV PATH $PATH:\$JAVA_HOME/bin

RUN tar -zxvf /home/admin/$BUILD_APP_NAME/tomcat/apache-tomcat-7.0.88.tar.gz  -C /home/admin/$BUILD_APP_NAME/tomcat/
ENV CATALINA_HOME /home/admin/$BUILD_APP_NAME/tomcat/apache-tomcat-7.0.88
ENV PATH $PATH:\$CATALINA_HOME/bin
COPY tomcat-redis-session-1.0-SNAPSHOT.jar /home/admin/diyStore/tomcat/apache-tomcat-7.0.88/lib
COPY jedis-2.7.2.jar /home/admin/diyStore/tomcat/apache-tomcat-7.0.88/lib
COPY commons-pool2-2.0.jar /home/admin/diyStore/tomcat/apache-tomcat-7.0.88/lib

ADD $BUILD_APP_NAME.war /home/admin/$BUILD_APP_NAME/tomcat/apache-tomcat-7.0.88/webapps/

ADD tomcat9.sh /etc/init.d/tomcat9
RUN chmod 755 /etc/init.d/tomcat9

EXPOSE 8080

ENTRYPOINT service tomcat9 start && tail -f $CATALINA_HOME/logs/catalina.out
