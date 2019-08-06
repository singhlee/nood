FROM java:8

MAINTAINER singhlee singhlee@qq.com

VOLUME /ROOT

ADD nood-config-0.0.1.jar nood-config.jar

RUN bash -c 'touch /nood-config.jar'

RUN cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
&& echo 'Asia/Shanghai' >/etc/timezone

EXPOSE 8762

ENTRYPOINT ["java", "-jar", "nood-config.jar"]
