#!/usr/bin/env bash

##############################################################################
##
##  Gradle startup script for UNIX
##
##############################################################################

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS=""

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD="maximum"

warn () {
    echo "$*"
}

die () {
    echo "$*"
    exit 1
}

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
case "`uname`" in
  CYGWIN* )
    cygwin=true
    ;;
  Darwin* )
    darwin=true
    ;;
  MINGW* )
    msys=true
    ;;
esac

# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD="$JAVA_HOME/jre/sh/java"
    else
        JAVACMD="$JAVA_HOME/bin/java"
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
    fi
else
    JAVACMD="java"
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH."
fi

# Increase the maximum file descriptors if we can.
if [ "$cygwin" = "false" -a "$darwin" = "false" -a "$MAX_FD" != "maximum" ] ; then
    MAX_FD_MAX=`ulimit -H -n`
    if [ $MAX_FD_MAX -lt 65536 ] ; then
        MAX_FD=$MAX_FD_MAX
    fi
    if [ $MAX_FD -lt 2048 ] ; then
        warn "The maximum number of file descriptors on this system is $MAX_FD, which may be insufficient for Gradle."
    fi
fi

FORCE=false
while [ $# -gt 0 ] ; do
    case "$1" in
        -f | --force )
            FORCE=true
            ;;
    esac
    shift
done

# For Cygwin, ensure paths are in UNIX format before anything is touched.
if $cygwin ; then
    [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --path --mixed "$JAVA_HOME"`
fi

# For Cygwin, switch paths to Windows format before running java
if $cygwin ; then
    APP_HOME=`cygpath --path --mixed "$APP_HOME"`
    CLASSPATH=`cygpath --path --mixed "$CLASSPATH"`
fi

if $msys ; then
    [ -n "$JAVA_HOME" ] && JAVA_HOME=`cygpath --path --mixed "$JAVA_HOME"`
fi

# Collect all arguments for the java command.
# shellcheck disable=SC2086
DEFAULT_JVM_OPTS=$JAVA_OPTS $GRADLE_OPTS $DEFAULT_JVM_OPTS "$@"

# Split up the JVM_OPTS into an array, recognizing quoted strings.
# shellcheck disable=SC2086
eval set -- $DEFAULT_JVM_OPTS
JVM_OPTS=()
while [ $# -gt 0 ] ; do
    case "$1" in
        -- )
            shift
            break
            ;;
        -*=* )
            OPTARG=`echo "$1" | sed 's/[-_a-zA-Z0-9]*=//'`
            JVM_OPTS+=("$1")
            shift
            ;;
        -* )
            JVM_OPTS+=("$1")
            shift
            ;;
        * )
            break
            ;;
    esac
done

exec "$JAVACMD" "${JVM_OPTS[@]}" -classpath "$CLASSPATH" org.gradle.wrapper.GradleWrapperMain "$@"