FROM openjdk:jre-slim

MAINTAINER Jim C. Mitchener <jcm@packetpan.org>

ADD build/libs/podcast-vertx-all.jar /podcast-server.jar

EXPOSE 9999

CMD ["/usr/bin/java", "-jar", "/podcast-server.jar"]
