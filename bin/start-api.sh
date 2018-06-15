#!/bin/sh
APP_HOME="$(cd "`dirname "$0"`"/..; pwd)"

START_PATH=${APP_HOME}/akka-api-cicd.jar

cd ${APP_HOME}

java -jar ${START_PATH}