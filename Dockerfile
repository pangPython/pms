FROM openjdk:8u212-jre
MAINTAINER MrBird 852252810@qq.com

COPY ./target/FEBS-Shiro.jar /febs/FEBS-Shiro.jar
ENTRYPOINT ["java", "-Xmx256m", "-jar", "/febs/FEBS-Shiro.jar"]