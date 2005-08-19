@echo off
rem You must have the variable CC_HOME set pointing to the CruiseControl installation directory

java -Xmx1024m -jar %CC_HOME%\main\dist\cruisecontrol.jar %*
