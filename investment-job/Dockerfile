FROM openjdk:21

ENV APP_HOME=/app
ENV JAVA_OPTS="-Xmx256m -Xms128m"
ENV DATABASE_URL="jdbc:postgresql://localhost:5432/status_invest_db"
ENV USERNAME="postgres"
ENV PASSWORD="root"
ENV TZ="America/Sao_Paulo"

RUN mkdir $APP_HOME
WORKDIR $APP_HOME

COPY build/libs/investment-job-1.0.0.jar $APP_HOME/app.jar

CMD ["java", "-jar", "app.jar"]