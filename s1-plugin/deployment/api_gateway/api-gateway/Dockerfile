FROM adoptopenjdk/openjdk11:jre11u-centos-nightly

EXPOSE 15502

ARG JAR_FILE=api_gateway-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ARG TENACITY_IP
ARG SOFIA_IP

ENV TENACITY_IP_ENV=${TENACITY_IP}
ENV SOFIA_IP_ENV=${SOFIA_IP}

RUN touch ./entrypoint.sh
RUN echo "java -jar ./app.jar --tenacity_xml_ip=${TENACITY_IP_ENV} --sofia_ip=${SOFIA_IP_ENV}" > ./entrypoint.sh
RUN chmod +x ./entrypoint.sh
CMD ./entrypoint.sh
