FROM java:8

MAINTAINER singhlee singhlee@qq.com

VOLUME /ROOT

ADD nood-eureka-0.0.1.jar nood-eureka.jar

RUN bash -c 'touch /nood-eureka.jar'

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "nood-eureka.jar"]
