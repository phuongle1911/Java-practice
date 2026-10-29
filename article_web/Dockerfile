FROM gradle:jdk21-alpine AS build
WORKDIR /article_web
COPY app ./app
COPY settings.gradle ./
COPY gradlew ./
COPY gradle ./gradle
RUN  ./gradlew clean build  

FROM tomcat:jdk21-openjdk
EXPOSE 8080
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY --from=build article_web/app/build/libs/*.war /usr/local/tomcat/webapps/ROOT.war