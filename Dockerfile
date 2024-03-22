FROM --platform=linux/amd64 openjdk:17-alpine

WORKDIR /service

COPY ./hackathon-timesheet-service.jar ./hackathon-timesheet-service.jar

RUN /bin/sh -c 'touch /service/hackathon-timesheet-service.jar'

CMD ["java", "-jar", "hackathon-timesheet-service.jar"]