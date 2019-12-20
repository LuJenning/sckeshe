#以什么镜像为基
FROM openjdk:8-jre
RUN mkdir /app
COPY order-server-0.0.1-SNAPSHOT.jar /app/
CMD java -jar /app/order-server-0.0.1-SNAPSHOT.jar
EXPOSE 9092
