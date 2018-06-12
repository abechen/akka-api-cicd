#!/bin/sh
export APP_HOME="$(cd "`dirname "$0"`"/..; pwd)"
export APP_NAME="$(basename $APP_HOME)"

. "${APP_HOME}/build_tool/build.conf"

# include log manipulation script start
. "${APP_HOME}"/libexec/log.sh
# include log manipulation script end

. "${APP_HOME}"/build_tool/build-utils.sh


function usage()
{
    echo "[Installation]
    Usage: `basename $0` [OPTIONS]
     e.g. `basename $0` -b
    OPTIONS:
       -h|--help                             Show this message
       -b|--build                            Build project
       -c|--clean                            Clean last build result
    "
}

args=`getopt -o hrbcd --long build,clean,help \
     -n 'build.sh' -- "$@"`

if [ $? != 0 ] ; then
  echo "terminating..." >&2 ;
  exit 1 ;
fi
eval set -- "$args"

while true ; do
  case "$1" in
    -b|--build )
        BUILD_OPT="true"
        break
        ;;
    -c|--clean )
        CLEAN_OPT="true"
        break
        ;;
    -h|--help )
        usage
        exit
        ;;
    --)
        usage
        exit
        ;;
    *)
        echo "internal error!" ;
        exit 1
        ;;
  esac
done

function build_project()
{
    log_info "Start to build project"

    build_project_func
}

function clean_project()
{
    if  [ ! -d "${APP_HOME}/$BUILD_DIR" ]; then
        log_warn "Not find folder ${APP_HOME}/$BUILD_DIR"
        exit 2
    fi

    log_info "Start to clean project"

    clean_project_func
}


# call function

if [[ -n $CLEAN_OPT ]]; then
    clean_project
fi

if [[ -n $BUILD_OPT ]]; then
    build_project
fi