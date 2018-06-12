# !/bin/bash

function build_project_func()
{
    log_info "[BUILD] Start to build $APP_NAME"

    cd "${APP_HOME}"

    log_info "[BUILD] sbt reload clean assembly"
    sbt reload clean assembly

    log_info "[BUILD] Build project success"
}

function clean_project_func()
{
    log_info "[CLEAN] Start to clean $APP_NAME"

    log_info "[CLEAN] sbt clean"
    sbt clean

    log_info "[CLEAN] Clean project success"
}