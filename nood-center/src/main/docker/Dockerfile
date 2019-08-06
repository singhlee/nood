FROM java:8

MAINTAINER singhlee singhlee@qq.com

VOLUME /ROOT

ADD nood-center-0.0.1.jar nood-center.jar

RUN bash -c 'touch /nood-center.jar'

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "nood-center.jar"]
