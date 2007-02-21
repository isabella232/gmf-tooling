DISPLAY=:0.0
export DISPLAY
java -Xmx1024m -cp ../../org.eclipse.releng.basebuilder/plugins/org.eclipse.equinox.launcher.jar org.eclipse.core.launcher.Main -application org.eclipse.ant.core.antRunner "$@"
