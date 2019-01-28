FROM tomcat:9-jre8
MAINTAINER leon_xi@163.com

RUN rm -Rf $CATALINA_HOME/webapps/ROOT
RUN rm -Rf $CATALINA_HOME/webapps/docs
RUN rm -Rf $CATALINA_HOME/webapps/examples
RUN rm -Rf $CATALINA_HOME/webapps/host-manager
RUN rm -Rf $CATALINA_HOME/webapps/manager

# Install Maven
ARG MAVEN_VERSION=3.6.0
ARG USER_HOME_DIR="/root"
ARG SHA=fae9c12b570c3ba18116a4e26ea524b29f7279c17cbaadc3326ca72927368924d9131d11b9e851b8dc9162228b6fdea955446be41207a5cfc61283dd8a561d2f
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  && echo "${SHA}  /tmp/apache-maven.tar.gz" | sha512sum -c - \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

COPY settings-docker.xml /usr/share/maven/ref/

# Install DUAN-home
ARG DUAN_SOURCE_PATH="/opt/xiaoji/duan/duan-home"

RUN mkdir -p $DUAN_SOURCE_PATH

COPY ./* $DUAN_SOURCE_PATH/

WORKDIR $DUAN_SOURCE_PATH

RUN mvn clean package \
  && cp $DUAN_SOURCE_PATH/target/ROOT.war $CATALINA_HOME/webapps/
  
RUN rm -Rf $DUAN_SOURCE_PATH \
  && rm -Rf /tmp \
  && rm -Rf $USER_HOME_DIR/.m2
