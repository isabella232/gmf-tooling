#./gmft-create-drops.sh -l 3.2.M201403121500 -i /home/data/users/mgolubev/milestones-3.2.M6a -o /home/data/users/mgolubev/drops

#!/bin/bash
#### key - value
# -i -- inputPath
# -o -- outputPath
# -l -- outputFilesLabel
# -e -- eclipse path
#### single keys
# -x -- don't use xtend
# -r -- don't add root to xtend
# set default paths, used when no corresponding key present
PATH_TO_ECLIPSE=/home/data/users/mgolubev/temp-eclipse/eclipse/
inputPath=/home/data/httpd/download.eclipse.org/modeling/gmp/gmf-tooling/updates/releases/
outputPath=/home/data/users/mgolubev/drops
useRoot=""
useXtend=""

now=$(date +"%T")
outputFilesLabel=""
#get shell parameters
echo "split params"
while [ "$#" -ge 1 ]
do
  case "$1" in
    "-i")
       inputPath=$2
       ;;
    "-o")
      outputPath=$2
       ;;
    "-e")
       PATH_TO_ECLIPSE=$2
       ;;
    "-l")
       outputFilesLabel=$2
       ;;
    "-x")
       useXtend="-x"
       ;;
    "-r")
       useRoot="-r"
       ;;
    esac
    shift
done;
##########################################################
    if [ -d "$PATH_TO_ECLIPSE" -a -x "$PATH_TO_ECLIPSE/eclipse" ]; then
        echo "*Script built-in path to eclipse binary: $PATH_TO_ECLIPSE"
    else
        echo "*Script built-in path to eclipse binary $PATH_TO_ECLIPSE\ doesn't exist, edit the script to specify correct path to eclipse"
        exit 1
    fi
    if [ -d "$inputPath" -a -w "$inputPath" ]; then
        echo "*Input path: $inputPath"
    else
        echo "$inputPath doesn't exist"
        exit 1
    fi
    if [ -d "$outputPath" -a -w "$outputPath" ]; then
        echo "*Output path: $outputPath"
    else
        echo "$outputPath doesn't exist"
        exit 1
    fi

if [ -z "$outputFilesLabel" ]; then
    echo "Chose release. Input one of parameter:"
    echo " [r] - releases,"
    echo " [s] - stable,"
    echo " [m] - milestone,"
    echo " [i] - integration,"
    echo " [n] - nightly"
    read b

    build="$(echo $b | awk '{print tolower($0)}')"
    if [ "$build" != "r" -a "$build" != "s" -a "$build" != "m" -a "$build" != "i" -a "$build" != "n" ]; then
        echo "unedfined type of build - $build" 
        exit 1
    fi
    echo "Input current version"
    read version
    mydate=$(date +'%Y%m%d')
    mytime=$(date +'%H%M')
    outputFilesLabel=$version$build$mydate$mytime
    echo "current label = $outputFilesLabel"
fi
##########################################################
TEMP_DIR=~/temp/gmf-packaging-$outputFilesLabel
mkdir -p $TEMP_DIR
TEMP_DIR=$(cd "$TEMP_DIR" && pwd )
echo "Creating temporary directory: $TEMP_DIR"

OUTPUT_PATH=$outputPath/gmf-packaging-$outputFilesLabel
mkdir -p $OUTPUT_PATH
OUTPUT_PATH=$(cd "$OUTPUT_PATH" && pwd )
echo "Creating output directory: $OUTPUT_PATH"

echo "Converting update site to runnable form"
$PATH_TO_ECLIPSE/eclipse -nosplash -consoleLog -application org.eclipse.equinox.p2.repository.repo2runnable -source $inputPath -destination $TEMP_DIR/drops/eclipse
cd $TEMP_DIR/drops
##########################################################

##########################################################
#UPDATE SITE
cd eclipse
zip -rq ../gmf-tooling-update-$outputFilesLabel.zip\
    *
#calculating gmf-tooling-update package checksum
md5sum gmf-tooling-update-$outputFilesLabel.zip > gmf-tooling-update-$outputFilesLabel.zip.md5
echo "Created gmf-tooling-update-$outputFilesLabel.zip"
cd ..

##########################################################
#SDK
#REMOVE#
#eclipse/plugins/org.eclipse.gmf.bridge.trace.source_*\
#ADD#
#eclipse/plugins/org.eclipse.gmf.runtime.lite.svg_*\+

zip -rq gmf-tooling-sdk-$outputFilesLabel.zip\
    eclipse/features/org.eclipse.gmf.sdk_*\
    eclipse/features/org.eclipse.gmf.doc_*\
    eclipse/features/org.eclipse.gmf.tooling.source_*\
    eclipse/features/org.eclipse.gmf.tooling_*\
    eclipse/features/org.eclipse.gmf.tooling.runtime_*\
    eclipse/features/org.eclipse.gmf.tooling.runtime.source_*\
    eclipse/plugins/org.eclipse.gmf.sdk_*\
    eclipse/plugins/org.eclipse.gmf.doc_*\
    eclipse/plugins/org.eclipse.gmf.doc.ui_*\
    eclipse/plugins/org.eclipse.gmf.common.source_*\
    eclipse/plugins/org.eclipse.gmf.codegen.source_*\
    eclipse/plugins/org.eclipse.gmf.codegen.edit.source_*\
    eclipse/plugins/org.eclipse.gmf.codegen.ui.source_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.source_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.edit.source_*\
    eclipse/plugins/org.eclipse.gmf.map.source_*\
    eclipse/plugins/org.eclipse.gmf.map.edit.source_*\
    eclipse/plugins/org.eclipse.gmf.bridge.source_*\
    eclipse/plugins/org.eclipse.gmf.bridge.ui.source_*\
    eclipse/plugins/org.eclipse.gmf.bridge.ui.dashboard.source_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.codegen.source_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.codegen.ui.source_*\
    eclipse/plugins/org.eclipse.gmf.tooldef.source_*\
    eclipse/plugins/org.eclipse.gmf.tooldef.edit.source_*\
    eclipse/plugins/org.eclipse.gmf.validate.source_*\
    eclipse/plugins/org.eclipse.gmf.ecore.editor.source_*\
    eclipse/plugins/org.eclipse.gmf.xpand.source_*\
    eclipse/plugins/org.eclipse.gmf.xpand.editor.source_*\
    eclipse/plugins/org.eclipse.gmf.xpand.qvtlibrary.source_*\
    eclipse/plugins/org.eclipse.gmf.common_*\
    eclipse/plugins/org.eclipse.gmf.codegen_*\
    eclipse/plugins/org.eclipse.gmf.codegen.edit_*\
    eclipse/plugins/org.eclipse.gmf.codegen.ui_*\
    eclipse/plugins/org.eclipse.gmf.graphdef_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.edit_*\
    eclipse/plugins/org.eclipse.gmf.map_*\
    eclipse/plugins/org.eclipse.gmf.map.edit_*\
    eclipse/plugins/org.eclipse.gmf.bridge_*\
    eclipse/plugins/org.eclipse.gmf.bridge.ui_*\
    eclipse/plugins/org.eclipse.gmf.bridge.ui.dashboard_*\
    eclipse/plugins/org.eclipse.gmf.tooling_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.codegen_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.codegen.ui_*\
    eclipse/plugins/org.eclipse.gmf.tooldef_*\
    eclipse/plugins/org.eclipse.gmf.tooldef.edit_*\
    eclipse/plugins/org.eclipse.gmf.validate_*\
    eclipse/plugins/org.eclipse.gmf.ecore.editor_*\
    eclipse/plugins/org.eclipse.gmf.xpand_*\
    eclipse/plugins/org.eclipse.gmf.xpand.editor_*\
    eclipse/plugins/org.eclipse.gmf.xpand.qvtlibrary_*\
    eclipse/plugins/org.eclipse.gmf.bridge.trace_*\
    eclipse/plugins/org.eclipse.gmf.tooling.runtime_*\
    eclipse/plugins/org.eclipse.gmf.runtime.lite.svg_*\
	eclipse/plugins/org.eclipse.gmf.runtime.lite.svg.source_*\
    eclipse/plugins/org.eclipse.gmf.tooling.runtime.source_*

#writing gmf-sdk package root files
cd $TEMP_DIR
mkdir -p "eclipse"
unzip -oq drops/eclipse/binary/org.eclipse.gmf.sdk_root_* -d eclipse
zip -rgq drops/gmf-tooling-sdk-$outputFilesLabel.zip eclipse
rm -rf "eclipse"
cd $TEMP_DIR/drops

#calculating gmf-sdk package checksum
md5sum gmf-tooling-sdk-$outputFilesLabel.zip > gmf-tooling-sdk-$outputFilesLabel.zip.md5
echo "Created gmf-tooling-sdk-$outputFilesLabel.zip"

##########################################################
#TOOLING-RUNTIME
zip -rq gmf-tooling-runtime-$outputFilesLabel.zip\
    eclipse/features/org.eclipse.gmf.tooling.runtime_*\
    eclipse/features/org.eclipse.gmf.tooling.runtime.source_*\
    eclipse/plugins/org.eclipse.gmf.tooling.runtime_*\
    eclipse/plugins/org.eclipse.gmf.tooling.runtime.source_*\
    eclipse/plugins/org.eclipse.gmf.runtime.lite.svg_*\
    eclipse/plugins/org.eclipse.gmf.runtime.lite.svg.source_*

#writing gmf-tooling-runtime package root files
cd $TEMP_DIR
mkdir -p "eclipse"
unzip -oq drops/eclipse/binary/org.eclipse.gmf.tooling.runtime_root_* -d eclipse
zip -rgq drops/gmf-tooling-runtime-$outputFilesLabel.zip eclipse
rm -rf "eclipse"
cd $TEMP_DIR/drops

#calculating gmf-tooling-runtime package checksum
md5sum gmf-tooling-runtime-$outputFilesLabel.zip > gmf-tooling-runtime-$outputFilesLabel.zip.md5
echo "Created gmf-tooling-runtime-$outputFilesLabel.zip"

##########################################################
#TESTS
#zip -rq gmf-tests-$outputFilesLabel.zip\
#    eclipse/features/org.eclipse.gmf.tests_*\
#    eclipse/plugins/org.eclipse.test_*\
#    eclipse/plugins/org.eclipse.ant.optional.junit_*\
#    eclipse/plugins/org.eclipse.gmf.tests_*\
#    eclipse/plugins/org.eclipse.gmf.tests.xpand
#
#writing gmf-tests package root files
#cd $TEMP_DIR
#mkdir -p "eclipse"
#unzip -oq drops/eclipse/binary/org.eclipse.gmf.tests_root_* -d eclipse
#zip -rgq drops/gmf-tests-$outputFilesLabel.zip #eclipse
#rm -rf "eclipse"
#cd $TEMP_DIR/drops
#
#calculating gmf-tests package checksum
#md5sum gmf-tests-$outputFilesLabel.zip > gmf-tests-$outputFilesLabel.zip.md5
#echo "Created gmf-tests-$outputFilesLabel.zip"

##########################################################
#SIMPLEMAP-RUNTIME
zip -rq gmf-tooling-simplemap-$outputFilesLabel.zip\
    eclipse/features/org.eclipse.gmf.tooling.simplemap_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.bridge.ui_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.diagram_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.diagram.properties_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.gmf_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.migrate.ui_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.model_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.model.delegates_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.model.edit_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.model.edit.properties_*\
    eclipse/plugins/org.eclipse.gmf.tooling.simplemap.model.triggers_*

#writing gmf-tooling-simplemap package root files
cd $TEMP_DIR
mkdir -p "eclipse"
unzip -oq drops/eclipse/binary/org.eclipse.gmf.tooling.simplemap_root_* -d eclipse
zip -rgq drops/gmf-tooling-simplemap-$outputFilesLabel.zip eclipse
rm -rf "eclipse"
cd $TEMP_DIR/drops

#calculating gmf-tooling-simplemap package checksum
md5sum gmf-tooling-simplemap-$outputFilesLabel.zip > gmf-tooling-simplemap-$outputFilesLabel.zip.md5
echo "Created gmf-tooling-simplemap-$outputFilesLabel.zip"

##########################################################
#XTEND2
if [ -z "$useXtend" ] 
then
zip -rq gmf-tooling-xtend2-"$outputFilesLabel".zip eclipse/features/org.eclipse.gmf.tooling.codegen.xtend2_*\
    eclipse/plugins/org.eclipse.gmf.codegen.xtend_*\
    eclipse/plugins/org.eclipse.gmf.codegen.xtend.ui_*

#writing gmf-tooling-xtend2 package root files
cd $TEMP_DIR
mkdir -p "eclipse"
if [ -z "$useRoot" ]
then
  unzip -oq drops/eclipse/binary/org.eclipse.gmf.tooling.codegen.xtend2_root_* -d eclipse
  zip -rgq drops/gmf-tooling-xtend2-$outputFilesLabel.zip eclipse
fi
rm -rf "eclipse"
cd $TEMP_DIR/drops
#calculating gmf-tooling-xtend2 package checksum
md5sum gmf-tooling-xtend2-$outputFilesLabel.zip > gmf-tooling-xtend2-$outputFilesLabel.zip.md5
echo "Created gmf-tooling-xtend2-$outputFilesLabel.zip"
fi
##########################################################
#copy result files to output dir
echo "Copying result to $OUTPUT_PATH"
cp *.zip $OUTPUT_PATH
cp *.md5 $OUTPUT_PATH


#deleting temporary files
echo "Deleting temporary directory $TEMP_DIR"
rm -rf "$TEMP_DIR"

#all is done
echo "Processing complete!"
