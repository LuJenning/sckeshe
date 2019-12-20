#以什么镜像为基
FROM openjdk:8-jre
RUN mkdir /app
COPY user-client-0.0.1-SNAPSHOT.jar /app/
CMD java -jar /app/user-client-0.0.1-SNAPSHOT.jar
EXPOSE 8040
