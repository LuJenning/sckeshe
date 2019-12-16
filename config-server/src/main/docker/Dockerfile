#以什么镜像为基
FROM openjdk:8-jre
##创建app目录进行存放jar
RUN mkdir /app
##将当前上下文环境下的jar复制到app目录下
COPY config-server-0.0.1-SNAPSHOT.jar /app/
##解析jar，用pro文件进行运行
CMD java -jar /app/config-server-0.0.1-SNAPSHOT.jar
##暴露8888端口给主机
EXPOSE 8974
