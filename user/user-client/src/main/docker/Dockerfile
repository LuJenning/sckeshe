#以什么镜像为基
FROM openjdk:8-jre
RUN mkdir /app
COPY user-client.jar /app/
CMD java -jar /app/user-client.jar
EXPOSE 9090
