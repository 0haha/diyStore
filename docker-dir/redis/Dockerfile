FROM ubuntu
ENV BUILD_APP_NAME diyStore

RUN apt-get update
RUN apt-get install -y redis-server

EXPOSE 6379

CMD ["redis-server"]
