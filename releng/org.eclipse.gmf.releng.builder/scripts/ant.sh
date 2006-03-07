#!/bin/sh
PROJECT_HOME='dirname "$0"'
ANT_CMD=${ANT_HOME}/bin/ant
exec "$ANT_CMD" "$@"
