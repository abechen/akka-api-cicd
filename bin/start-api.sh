#!/bin/sh
APP_HOME="$(cd "`dirname "$0"`"/..; pwd)"

START_PATH=${APP_HOME}/akka_api.jar

cd ${APP_HOME}

java -jar ${START_PATH}