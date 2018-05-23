export BUILD_APP_NAME=diyStore
export JAVA_HOME=/home/admin/$BUILD_APP_NAME/java/jdk1.8.0_161
export TOMCAT_HOME=/home/admin/$BUILD_APP_NAME/tomcat/apache-tomcat-7.0.88

case $1 in
start)
  sh $TOMCAT_HOME/bin/startup.sh
;;
stop)
  sh $TOMCAT_HOME/bin/shutdown.sh
;;
restart)
  sh $TOMCAT_HOME/bin/shutdown.sh
  sh $TOMCAT_HOME/bin/startup.sh
;;
esac
exit 0

