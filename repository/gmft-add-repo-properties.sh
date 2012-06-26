#!/bin/bash
BUILD_HOME=/home/data/users/temp-eclipse/add-repo-props
APP_NAME=org.eclipse.wtp.releng.tools.addRepoProperties
devworkspace="${BUILD_HOME}"/addRepoPropertiesWorkspace
# remember, the '&' should NOT be unescaped here ... the p2 api (or underlying xml) will escape it.
devArgs=" -DartifactRepoDirectory=/home/data/users/mgolubev/temp-eclipse/_releases-3.0.0/ \
    -Dp2ArtifactRepositoryName=GMFToolingReleaseArtifacts \
    -Dp2MirrorsURL=http://www.eclipse.org/downloads/download.php?format=xml&file=/modeling/gmp/gmf-tooling/updates/releases/ \
    "

echo "   cmd:          " $0
echo "   APP_NAME:     " $APP_NAME
echo "   devworkspace: " $devworkspace
echo "   devArgs:      " $devArgs
echo

eclipse/eclipse  -debug -nosplash -consolelog -console \
   -data $devworkspace --launcher.suppressErrors -application ${APP_NAME} \
   -vmargs $devArgs

