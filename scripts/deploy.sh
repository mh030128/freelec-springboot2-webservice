#!/bin/bash
set -e

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=springboot-web-practise

echo "> Copy Build File"
cp $REPOSITORY/ZIP/*.jar $REPOSITORY/

echo "> 현재 구동중인 어플리케이션 pid 확인"
CURRENT_PID=$(pgrep -f $PROJECT_NAME)

if [ -z "$CURRENT_PID" ]; then
  echo "> 현재 구동 중인 어플리케이션이 없습니다."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> 새 어플리케이션 배포"
JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"
chmod +x $JAR_NAME

echo "> $JAR_NAME 실행"

nohup java -jar \
  -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,file:/home/ec2-user/app/application-oauth.properties,file:/home/ec2-user/app/application-real-db.properties \
  -Dspring.profiles.active=real \
  $JAR_NAME > $REPOSITORY/deploy.log 2>&1 &
