FROM ubuntu
ENV BUILD_APP_NAME diyStore

RUN  mkdir -p /home/admin/$BUILD_APP_NAME/java && \
     mkdir -p /home/admin/$BUILD_APP_NAME/tomcat

COPY apache-tomcat-9.0.4.tar.gz /home/admin/$BUILD_APP_NAME/tomcat
COPY jdk-8u161-linux-x64.tar.gz /home/admin/$BUILD_APP_NAME/java

RUN tar -zxvf  /home/admin/$BUILD_APP_NAME/java/jdk-8u161-linux-x64.tar.gz -C /home/admin/$BUILD_APP_NAME/java/
ENV JAVA_HOME /home/admin/$BUILD_APP_NAME/java/jdk1.8.0_161
ENV PATH $PATH:\$JAVA_HOME/bin

RUN tar -zxvf /home/admin/$BUILD_APP_NAME/tomcat/apache-tomcat-9.0.4.tar.gz  -C /home/admin/$BUILD_APP_NAME/tomcat/
ENV CATALINA_HOME /home/admin/$BUILD_APP_NAME/tomcat/apache-tomcat-9.0.4
ENV PATH $PATH:\$CATALINA_HOME/bin

ADD $BUILD_APP_NAME.war /home/admin/$BUILD_APP_NAME/tomcat/apache-tomcat-9.0.4/webapps/

ADD tomcat9.sh /etc/init.d/tomcat9
RUN chmod 755 /etc/init.d/tomcat9

EXPOSE 8080

ENTRYPOINT service tomcat9 start && tail -f $CATALINA_HOME/logs/catalina.out
