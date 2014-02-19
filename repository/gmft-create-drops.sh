#!/bin/bash
# Script may take 3 command line parameters:
# $1: Path to input gmf repository
# $2: Path to output packages
# $3: Label to append to the version string when creating drop files, e.g. M5 or RC1
#

PATH_TO_ECLIPSE=~/temp-eclipse/eclipse/

#check script input parameters
if [ $# -eq 3 ];
then
    inputPath=$1
    outputPath=$2

    if [ -d "$inputPath" -a -w "$inputPath" ]
    then
        echo "Input path: $inputPath"
    else
        echo "$inputPath doesn't exist"
        exit 1
    fi

    if [ -d "$outputPath" -a -w "$outputPath" ]
    then
        echo "Output path: $outputPath"
    else
        echo "$outputPath doesn't exist"
        exit 1
    fi

    if [ -n "$3" ];
    then
        outputFilesLabel=$3
        echo "Output files label: $outputFilesLabel"
    fi
else
        echo "Input parameters are wrong: you must specify input repo path, output path and result prefix"
        exit 1
fi

#check predefined path to eclipse binary
if [ -d "$PATH_TO_ECLIPSE" -a -x "$PATH_TO_ECLIPSE/eclipse" ]
then
    echo "Script built-in path to eclipse binary: $PATH_TO_ECLIPSE"
else
    echo "Script built-in path to eclipse binary $PATH_TO_ECLIPSE doesn't exist, edit the script to specify correct path to eclipse"
    exit 1
fi

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

#SDK-EXPERIMENTAL
zip -rq gmf-tooling-sdk-experimental-$outputFilesLabel.zip\
    eclipse/features/org.eclipse.gmf.runtime.thirdparty_*\
    eclipse/features/org.eclipse.gmf.sdk.experimental.source_*\
    eclipse/features/org.eclipse.gmf.sdk.experimental_*\
    eclipse/plugins/org.eclipse.gmf.codegen.lite.source_*\
    eclipse/plugins/org.eclipse.gmf.codegen.lite.ui.source_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.editor.source_*\
    eclipse/plugins/org.eclipse.gmf.runtime.lite.source_*\
    eclipse/plugins/org.eclipse.gmf.map.editor.source_*\
    eclipse/plugins/org.eclipse.gmf.codegen.lite_*\
    eclipse/plugins/org.eclipse.gmf.codegen.lite.ui_*\
    eclipse/plugins/org.eclipse.gmf.graphdef.editor_*\
    eclipse/plugins/org.eclipse.gmf.runtime.lite_*\
    eclipse/plugins/org.eclipse.gmf.map.editor_*

#writing gmf-tooling-sdk-experimental package root files
cd $TEMP_DIR
mkdir -p "eclipse"
unzip -oq drops/eclipse/binary/org.eclipse.gmf.sdk.experimental_root_* -d eclipse
zip -rgq drops/gmf-tooling-sdk-experimental-$outputFilesLabel.zip eclipse
rm -rf "eclipse"
cd $TEMP_DIR/drops

#calculating gmf-tooling-sdk-experimental package checksum
md5sum gmf-tooling-sdk-experimental-$outputFilesLabel.zip > gmf-tooling-sdk-experimental-$outputFilesLabel.zip.md5
echo "Created gmf-tooling-sdk-experimental-$outputFilesLabel.zip"

#SDK
zip -rq gmf-tooling-sdk-$outputFilesLabel.zip\
    eclipse/features/org.eclipse.gmf.doc_*\
    eclipse/features/org.eclipse.gmf.sdk_*\
    eclipse/features/org.eclipse.gmf.tooling.source_*\
    eclipse/features/org.eclipse.gmf.tooling_*\
    eclipse/features/org.eclipse.gmf.tooling.runtime_*\
    eclipse/features/org.eclipse.gmf.tooling.runtime.source_*\
    eclipse/plugins/org.eclipse.gmf.doc_*\
    eclipse/plugins/org.eclipse.gmf.doc.ui_*\
    eclipse/plugins/org.eclipse.gmf.sdk_*\
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
	eclipse/plugins/org.eclipse.gmf.bridge.trace.source_*\
    eclipse/plugins/org.eclipse.gmf.tooling.runtime_*\
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

#TOOLING-RUNTIME
zip -rq gmf-tooling-runtime-$outputFilesLabel.zip\
    eclipse/features/org.eclipse.gmf.tooling.runtime_*\
    eclipse/plugins/org.eclipse.gmf.tooling.runtime_*\
    eclipse/plugins/org.eclipse.gmf.runtime.lite.svg_*

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

#TOOLING-RUNTIME-SOURCE
zip -rq gmf-tooling-runtime-source-$outputFilesLabel.zip\
    eclipse/features/org.eclipse.gmf.tooling.runtime.source_*\
    eclipse/plugins/org.eclipse.gmf.tooling.runtime.source_*\
    eclipse/plugins/org.eclipse.gmf.runtime.lite.svg.source_*

#writing gmf-tooling-runtime-source package root files
cd $TEMP_DIR
mkdir -p "eclipse"
unzip -oq drops/eclipse/binary/org.eclipse.gmf.tooling.runtime_root_* -d eclipse
zip -rgq drops/gmf-tooling-runtime-source-$outputFilesLabel.zip eclipse
rm -rf "eclipse"
cd $TEMP_DIR/drops

#calculating gmf-tooling-runtime-source package checksum
md5sum gmf-tooling-runtime-source-$outputFilesLabel.zip > gmf-tooling-runtime-source-$outputFilesLabel.zip.md5
echo "Created gmf-tooling-runtime-source-$outputFilesLabel.zip"

#TOOLING-SIMPLEMAP
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

#copy result files to output dir
echo "Copying result to $OUTPUT_PATH"
cp *.zip $OUTPUT_PATH
cp *.md5 $OUTPUT_PATH

#deleting temporary files
echo "Deleting temporary directory $TEMP_DIR"
rm -rf "$TEMP_DIR"

#all is done
echo "Processing complete!"