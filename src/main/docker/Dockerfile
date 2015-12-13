# Thanks https://spring.io/guides/gs/spring-boot-docker/
# http://docs.docker.com/engine/reference/builder/
FROM java:8
VOLUME /tmp
ADD VkToYandexMusic-1.0.0.jar vk-to-yandex-web.jar
RUN bash -c 'touch /vk-to-yandex-web.jar'
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/vk-to-yandex-web.jar"]
