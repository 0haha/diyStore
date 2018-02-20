#!/bin/bash

###### error code specification ######
# Please update this documentation if new error code is added.
# 1  => reserved for script error
# 2  => bad usage
# 3  => tomcat start failed
# 4  => nginx start failed

export PROG_NAME=$0
export ACTION=$1
export APP_NAME="diyStore"
export JDK_PATH="./tomcat&&jdk/"
export TOMCAT_PATH="./tomcat&&jdk/"
export NGINX_PATH="./nginx/"
export JDK_TAR_NAME="jdk-8u161-linux-x64.tar.gz"
export TOMCAT_TAR_NAME="apache-tomcat-9.0.4.tar.gz"
export NGINX_CONF_NAME="nginx.conf"
export ipa="ipa"
export ipb="ipb"

usage(){
   echo "Usage:sudo $PROG_NAME {start|stop|restart|restartNginx|restartTomcat}"
   exit 2
}

if [ $# -lt 1 ]; then
   usage
   exit 2
fi

check_war_exist(){
   if [ ! -e "${TOMCAT_PATH}${APP_NAME}".war ];then
      echo "The ${APP_NAME}.war does not exist!"
      exit 3
   fi
   if [ ! -e "${JDK_PATH}${JDK_TAR_NAME}"  ];then
      echo "The ${JDK_TAR_NAME} does not exist!"
      exit 3
   fi
   if [ ! -e "${TOMCAT_PATH}${TOMCAT_TAR_NAME}" ];then
      echo "The ${TOMCAT_TAR_NAME} does not exist!"
      exit 3
   fi
}

check_conf_exist(){
   if [ ! -e "${NGINX_PATH}${NGINX_CONF_NAME}" ];then
       echo "The ${NGINX_CONF_NAME} does not exist!"
       exit 4
   fi
}

produce_nginx_conf(){

 export ipa=$(sudo docker inspect $(docker ps| grep 'webbase:v1' |awk '{print $1}') | grep '"IPAddress"'| head -1 | awk -F \" '{ print $4}')
 export ipb=$(sudo docker inspect $(docker ps| grep 'webbase:v2' |awk '{print $1}') | grep '"IPAddress"'| head -1 | awk -F \" '{ print $4}')

     sed -i "s/ipa/${ipa}/g" nginx/nginx.conf
     sed -i "s/ipb/${ipb}/g" nginx/nginx.conf

}

write_back_nginx_conf(){

     sed -i  "34s/[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}/ipa/g" nginx/nginx.conf
     sed -i  "35s/[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}\.[0-9]\{1,3\}/ipb/g" nginx/nginx.conf
}

build_and_run_tomcatjdk_docker(){
   echo "Now begin to build the docker images webbase:v1 and webbase:v2"
   docker build -t webbase:v1 ${TOMCAT_PATH} || exit 3
   docker build -t webbase:v2 ${TOMCAT_PATH} || exit 3
   docker run -d webbase:v1 || exit 3
   docker run -d webbase:v2 || exit 3
}

clean_docker_none(){
   echo "Now begin to stop the container of image<none> and remove the image<none>..."
   for v in $(docker images | grep 'none' | awk '{print $3}');do
           docker ps -a |  grep $v | awk '{print $1}' |  xargs --no-run-if-empty docker stop
           docker ps -a |  grep $v | awk '{print $1}' |  xargs --no-run-if-empty docker rm
           docker rmi $v
   done
}

run_nginx_docker(){
  echo "Now begin to run the nginx docker images..."
  docker run -v $(cd `dirname $0`;pwd)/nginx/nginx.conf:/etc/nginx/nginx.conf:rw -d -p 5003:80 nginx:latest || exit 4
}

stop_tomcatjdk_docker(){
    docker ps -a |  grep 'webbase:v1' | awk '{print $1}' | xargs --no-run-if-empty docker stop || exit 1
    docker ps -a |  grep 'webbase:v2' | awk '{print $1}' | xargs --no-run-if-empty docker stop || exit 1
}

stop_nginx_docker(){

     write_back_nginx_conf
     docker ps -a |  grep 'nginx' | awk '{print $1}' |  xargs --no-run-if-empty docker stop || exit 1

}

start(){
   check_war_exist
   check_conf_exist
   build_and_run_tomcatjdk_docker
   clean_docker_none
   produce_nginx_conf
   run_nginx_docker
}

stop(){
   stop_tomcatjdk_docker
   stop_nginx_docker
}

restart(){
  stop
  start
}

restartNginx(){
  stop_nginx_docker
  write_back_nginx_conf
  produce_nginx_conf
  run_nginx_docker
}

restartTomcat(){
  stop_tomcatjdk_docker
  build_and_run_tomcatjdk_docker
  clean_docker_none
}


case "$ACTION" in
   start)
      start
      ;;
   stop)
      stop
      ;;
   restart)
      restart
      ;;
   restartNginx)
      restartNginx
      ;;
   restartTomcat)
      restartTomcat
      ;;
   stopNginx)
      stop_nginx_docker
      ;;
   *)
      usage
      ;;
esac