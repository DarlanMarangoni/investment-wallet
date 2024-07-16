FROM openjdk:21

ENV APP_HOME /app
ENV JAVA_OPTS="-Xmx256m -Xms128m"
ENV DATABASE_URL="jdbc:postgresql://3.********5:5432/db_investimento"
ENV USERNAME="dar******r"
ENV PASSWORD="A6*********24"
ENV TZ="America/Sao_Paulo"

RUN mkdir $APP_HOME
WORKDIR $APP_HOME

COPY build/libs/investment-1.0.1.jar $APP_HOME/app.jar

CMD ["java", "-jar", "app.jar"]