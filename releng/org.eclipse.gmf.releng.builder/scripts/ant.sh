#!/bin/sh
PROJECT_HOME='dirname "$0"'
ANT_HOME=/usr/lib/apache-ant-1.6.5
ANT_CMD=${ANT_HOME}/bin/ant
exec "$ANT_CMD" "$@"
